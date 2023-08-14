package util;

public enum Horas {
    CERO("00:00 AM", 0),
    UNO("01:00 AM", 1),
    DOS("02:00 AM", 2),
    TRES("03:00 AM", 3),
    CUATRO("04:00 AM", 4),
    CINCO("05:00 AM", 5),
    SEIS("06:00 AM", 6),
    SIETE("07:00 AM", 7),
    OCHO("08:00 AM", 8),
    NUEVE("09:00 AM", 9),
    DIES("10:00 AM", 10),
    ONCE("11:00 AM", 11),
    DOCE("12:00 PM", 12),
    TRECE("01:00 PM", 13),
    CATORCE("02:00 PM", 14),
    QUINCE("03:00 PM", 15),
    DIECISEIS("04:00 PM", 16),
    DIECISIETE("05:00 PM", 17),
    DIECIOCHO("06:00 PM", 18),
    DIECINUEVE("07:00 PM", 19),
    VEINTE("08:00 PM", 20),
    VEINTIUNO("09:00 PM", 21),
    VEINTIDOS("10:00 PM", 22),
    VEINTITRES("11:00 PM", 23);
    
    public final String formato;
    public final int valor;
    
    private Horas(String formato, int valor){
        this.formato = formato;
        this.valor = valor;
    }
}
