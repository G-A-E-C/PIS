package controlador.adap;

import controlador.lista.ListaEnlazada;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class AdaptadorDao<T> implements InterfazDao<T> {

    private final Conexion conex;
    private final Class clas;

    public AdaptadorDao(Class clas) {
        this.conex = new Conexion();
        this.clas = clas;
    }

    @Override
    public int guardar(T obj) throws Exception {

        String query = insertQuery(obj);

        int idGenerated = -1;

        PreparedStatement statement
                = conex.getConnection().prepareStatement(query,
                Statement.RETURN_GENERATED_KEYS);

        statement.executeUpdate();

        ResultSet generatedKeys = statement.getGeneratedKeys();
        if (generatedKeys.next()) {
            idGenerated = generatedKeys.getInt(1);
        }

        conex.getConnection().close();
        conex.setConnection(null);

        return idGenerated;
    }

    @Override
    public void actualizar(T obj, String id) throws Exception {

        String query = updateQuery(obj, id);

        Statement st = conex.getConnection().createStatement();

        st.executeUpdate(query);

        conex.getConnection().close();
        conex.setConnection(null);

    }

    @Override
    public ListaEnlazada<T> listar() {

        ListaEnlazada<T> lista = new ListaEnlazada<>();

        String query = String.format("SELECT * FROM %s", camelToSnake(clas.getSimpleName()));

        try {

            Statement stmt = conex.getConnection().createStatement();

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                lista.insertar(mapping(rs));
            }

        } catch (SQLException | InvocationTargetException | NoSuchMethodException | IllegalAccessException |
                 InstantiationException e) {
            throw new RuntimeException(e);
        }

        return lista;
    }

    @Override
    public T obtener(Object value, String id) {

        T data = null;

        String query = querySelect(id, value);

        try {

            Statement stmt = conex.getConnection().createStatement();

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                data = mapping(rs);
            }

        } catch (SQLException | InvocationTargetException | NoSuchMethodException | IllegalAccessException |
                 InstantiationException e) {
            throw new RuntimeException(e);
        }

        return data;
    }

    private String querySelect(String id, Object value){

        StringBuilder select = new StringBuilder("SELECT * FROM ");

        select.append(camelToSnake(clas.getSimpleName()));

        select.append(" WHERE ");

        select.append(camelToSnake(id))
              .append(" = ")
              .append(formatValue(value));

        return select.toString();
    }

    private String camelToSnake(String camel) {

        StringBuilder snake = new StringBuilder();

        char c = camel.charAt(0);
        snake.append(Character.toLowerCase(c));

        for (int i = 1; i < camel.length(); i++) {

            char ch = camel.charAt(i);

            if (Character.isUpperCase(ch)) {
                snake.append('_');
                snake.append(Character.toLowerCase(ch));
            } else {
                snake.append(ch);
            }
        }

        return snake.toString();
    }

    private String snakeToCamel(String snake) {

        snake = snake.substring(0, 1).toLowerCase()
                + snake.substring(1);

        StringBuilder camel = new StringBuilder(snake);

        for (int i = 0; i < camel.length(); i++) {

            if (camel.charAt(i) == '_') {

                camel.deleteCharAt(i);
                camel.replace(
                        i, i + 1,
                        String.valueOf(
                                Character.toUpperCase(
                                        camel.charAt(i))));
            }
        }

        return camel.toString();
    }

    public String updateQuery(T obj, String id) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {

        HashMap<String, Object> objMapped = mapping(obj);

        Object condition = null;

        StringBuilder update = new StringBuilder("UPDATE ");

        update.append(camelToSnake(obj.getClass().getSimpleName()));

        update.append(" SET ");

        for (var values : objMapped.entrySet()) {

            if(values.getKey().equals(id)) condition = values.getValue();

            update.append(values.getKey())
                    .append(" = ")
                    .append(formatValue(values.getValue()))
                    .append(", ");
        }

        update = new StringBuilder(update.substring(0, update.length() - 2));

        update.append(" WHERE ");

        assert condition != null;

        update.append(camelToSnake(id))
                .append(" = ")
                .append(formatValue(condition));

        return update.toString();
    }

    public String insertQuery(T obj) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {

        HashMap<String, Object> objMapped = mapping(obj);

        StringBuilder insert = new StringBuilder("INSERT INTO ");

        insert.append(camelToSnake(obj.getClass().getSimpleName()));

        insert.append(" (");

        for (var attribute : objMapped.entrySet()) {
            insert.append(attribute.getKey()).append(", ");
        }

        insert = new StringBuilder(insert.substring(0, insert.length() - 2));

        insert.append(") VALUES (");

        for (var value : objMapped.entrySet()) {
            insert.append(formatValue(value.getValue())).append(", ");
        }

        insert = new StringBuilder(insert.substring(0, insert.length() - 2));

        insert.append(")");

        return insert.toString();
    }

    private String formatValue(Object value) {

        if (value.getClass().getSimpleName().equals("String")) return '"' + value.toString() + '"';

        if (value.getClass().getSimpleName().equals("Integer") || value.getClass().getSimpleName().equals("Double")) {
            return value.toString();
        }

        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        return '"' + simpleDate.format(value) + '"';

    }

    private HashMap<String, Object> mapping(T obj) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        HashMap<String, Object> objMapped = new HashMap<>();

        for (Field fld : obj.getClass().getDeclaredFields()) {

            String attribute = fld.getName();

            Method method = obj.getClass().getMethod(snakeToCamel("get_"+attribute));

            Object value = method.invoke(obj);

            if (value != null) objMapped.put(camelToSnake(attribute), value);

        }

        return objMapped;
    }

    private T mapping(ResultSet rs) throws SQLException, InvocationTargetException, NoSuchMethodException, IllegalAccessException, InstantiationException {

        T data = null;

        data = (T) clas.getDeclaredConstructor().newInstance();

        for(Field fld : clas.getDeclaredFields()) dataType(fld, rs, data, fld.getName());

        return data;
    }

    private void dataType(Field fld, ResultSet rs, T data, String attribute) throws NoSuchMethodException, SQLException, InvocationTargetException, IllegalAccessException {

        Method method;

        if(fld.getType().getSimpleName().equals("String")) {
            method = clas.getMethod(snakeToCamel("set_"+ attribute), String.class);
            method.invoke(data, rs.getString(camelToSnake(attribute)));
        }

        if(fld.getType().getSimpleName().equals("int")){
            method = clas.getMethod(snakeToCamel("set_"+ attribute), int.class);
            method.invoke(data, rs.getInt(camelToSnake(attribute)));
        }

        if(fld.getType().getSimpleName().equals("double")){
            method = clas.getMethod(snakeToCamel("set_"+ attribute), double.class);
            method.invoke(data, rs.getDouble(camelToSnake(attribute)));
        }

        if (fld.getType().getSimpleName().equalsIgnoreCase("Date")) {
            method = clas.getMethod(snakeToCamel("set_"+ attribute), Date.class);
            method.invoke(data, rs.getDate(camelToSnake(attribute)));
        }

    }

}
