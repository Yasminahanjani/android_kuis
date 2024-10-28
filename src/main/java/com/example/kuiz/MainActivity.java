package com.example.kuiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView kuis;
    RadioGroup rg;
    RadioButton PilihanA, PilihanB, PilihanC, PilihanD;
    int nomor = 0;
    public static int hasil, benar, salah;

    String [] pertanyaan_kuis = new String[]{
            "1. Presiden Indonesia Yang Pertama Adalah?",
            "2. Arti Lambang Bintang Pada Lambang Garuda Adalah?",
            "3. Ibukota Indonesia Adalah?",
            "4. Warna Bendera Indonesia Adalah?",
            "5. Siapakah Pengetik Naskah Teks Proklamasi Negara Indonesia?",
            "6. Siapakah Nama Pencipta Lagu Indonesia Raya?",
            "7. Pada Tanggal Berapa Indonesia Merdeka?",
            "8. Berapa Jumlah Provinsi di Indonesia Pada Masa Awal Kemerdekaan?",
            "9. Berapa Lama Jepang Menjajah Indonesia?",
            "10. Siapakah Yang Pertama Kali Menjajah Indonesia?"

    };

    String [] pilihan_jawaban = new String[]{
            "Soekarno", "Habibi", "Jokowi", "Megawati",
            "Ketuhanan Yang Maha Esa", "Kelautan Indonesia", "Bintang Kejora", "Bintang Kecil",
            "Jakarta", "Bandung", "Yogyakarta", "Surabaya",
            "Merah Biru", "Merah Putih", "Putih Merah", "Bintang-Bintang",
            "Fatmawati", "Sukotjo", "Sayuti Melik", "Ahmad Soebarjo",
            "Ibu Sud", "Ismail Marzuki", "W.R Soepratman", "Husein Mutahar",
            "13 September", "9 Februari", "5 Mei", "17 Agustus",
            "34 Provinsi", "8 Provinsi", "5 Provinsi", "6 provinsi",
            "3,5 Tahun", "1 Tahun", "1,5 Tahun", "5 Tahun",
            "Belanda", "Portugis", "Inggris", "Spanyol",

    };

    String [] jawaban_benar = new String[]{
            "Soekarno",
            "Ketuhanan Yang Maha Esa",
            "Jakarta",
            "Merah Putih",
            "Sayuti Melik",
            "W.R Soepratman",
            "17 Agustus",
            "8 Provinsi",
            "3,5 Tahun",
            "Portugis",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //super untuk memanggil constructor, atribut, method
        setContentView(R.layout.activity_main);//tata letak yang dipanggil oleh id

        kuis=(TextView) findViewById(R.id.kuis);//memilih object
        rg = (RadioGroup) findViewById(R.id.pilihan);
        PilihanA = (RadioButton) findViewById(R.id.pilihanA);
        PilihanB = (RadioButton) findViewById(R.id.pilihanB);
        PilihanC = (RadioButton) findViewById(R.id.pilihanC);
        PilihanD = (RadioButton) findViewById(R.id.pilihanD);

        kuis.setText(pertanyaan_kuis[nomor]);
        PilihanA.setText(pilihan_jawaban[0]);
        PilihanB.setText(pilihan_jawaban[1]);
        PilihanC.setText(pilihan_jawaban[2]);
        PilihanD.setText(pilihan_jawaban[3]);

    }

    public void next(View view){
        RadioButton jawaban_user = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
        String ambil_jawaban_user = jawaban_user.getText().toString();
        if (ambil_jawaban_user.equalsIgnoreCase(jawaban_benar[nomor])) benar++;
        else salah++;
        nomor++;
        if (nomor< pertanyaan_kuis.length){
            kuis.setText(pertanyaan_kuis[nomor]);
            PilihanA.setText(pilihan_jawaban[(nomor*4)+0]);
            PilihanB.setText(pilihan_jawaban[(nomor*4)+1]);
            PilihanC.setText(pilihan_jawaban[(nomor*4)+2]);
            PilihanD.setText(pilihan_jawaban[(nomor*4)+3]);
        }
        else {
            hasil=benar * 10;
            Intent selesai = new Intent(getApplicationContext(),HasilKuis.class);
            startActivity(selesai);
        }
    }
}