package id.muhammadfaisal.parkee.util;

public class Constant {
    public static class RC {
        public static final int NOT_ALLOWED_PARKING = 204;
        public static final int INTERNAL_SERVER_ERROR = 500;
        public static final int SUCCESS = 200;
        public static final int DATA_NOT_F0UND = 404;
    }

    public static class RM {
        public static final String NOT_ALLOWED_PARKING = "Gagal!. Kendaraan Belum Keluar Parkir.";
        public static final String SUCCESS_ADD_VEHICLE = "Berhasil, Silahkan Masuk!";
        public static final String DATA_FOUND = "Data Ditemukan!";
        public static final String DATA_NOT_FOUND = "Data Tidak Ditemukan!";
        public static final String SUCCESS = "Berhasil";
        public static final String CANNOT_PROCESS_INQUIRY = "Gagal Mendapatkan Data. Pastikan anda memasukkan data dengan benar!";
    }

    public static class PaymentStatus {
        public static final int PAID = 2;
        public static final int PENDING = 3;
        public static final int NOT_PAID = 1;
    }
    public static class PaymentStatusText {
        public static final String PAID = "Telah Dibayar";
        public static final String PENDING = "Sedang Transaksi";
        public static final String NOT_PAID = "Belum Dibayar";
    }
}
