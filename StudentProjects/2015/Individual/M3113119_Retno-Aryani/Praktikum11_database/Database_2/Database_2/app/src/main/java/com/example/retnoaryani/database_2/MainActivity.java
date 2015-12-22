package com.example.retnoaryani.database_2;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    SQLiteHelper sqLiteHelper = new SQLiteHelper(this);

    TableLayout tabelBiodata;
    Button buttonTambahBiodata;
    ArrayList<Button> buttonEdit = new ArrayList<Button>();
    ArrayList<Button> buttonDelete = new ArrayList<Button>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabelBiodata = (TableLayout) findViewById(R.id.tableBiodata);
        buttonTambahBiodata = (Button) findViewById(R.id.buttonTambahBiodata);
        buttonTambahBiodata.setOnClickListener(this);

        TableRow barisTabel = new TableRow(this);
        barisTabel.setBackgroundColor(Color.RED);

        TextView viewHeaderId = new TextView(this);
        TextView viewHeaderNama = new TextView(this);
        TextView viewHeaderAlamat = new TextView(this);
        TextView viewHeaderAction = new TextView(this);

        viewHeaderId.setText("ID");
        viewHeaderNama.setText("Nama");
        viewHeaderAlamat.setText("Alamat");
        viewHeaderAction.setText("Action");

        viewHeaderId.setPadding(5, 1, 5, 1);
        viewHeaderNama.setPadding(5, 1, 5, 1);
        viewHeaderAlamat.setPadding(5, 1, 5, 1);
        viewHeaderAction.setPadding(5, 1, 5, 1);

        barisTabel.addView(viewHeaderId);
        barisTabel.addView(viewHeaderNama);
        barisTabel.addView(viewHeaderAlamat);
        barisTabel.addView(viewHeaderAction);

        tabelBiodata.addView(barisTabel, new TableLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));

        ArrayList<HashMap<String, String>> arrayListBiodata = sqLiteHelper
                .tampil_semua_biodata();

        if (arrayListBiodata.size() > 0) {

            for (int i = 0; i < arrayListBiodata.size(); i++) {

                // ambil masing-masing hasmap dari arrayListBiodata
                HashMap<String, String> hashMapRecordBiodata = arrayListBiodata
                        .get(i);

                // JSONObject jsonChildNode = arrayBiodata.getJSONObject(i);
                String name = hashMapRecordBiodata.get("nama");
                String alamat = hashMapRecordBiodata.get("alamat");
                String id = hashMapRecordBiodata.get("id_biodata");

                System.out.println("Nama :" + name);
                System.out.println("Alamat :" + alamat);
                System.out.println("ID :" + id);

                barisTabel = new TableRow(this);

                if (i % 2 == 0) {
                    barisTabel.setBackgroundColor(Color.LTGRAY);
                }

                TextView viewId = new TextView(this);
                viewId.setText(id);
                viewId.setPadding(5, 1, 5, 1);
                barisTabel.addView(viewId);

                TextView viewNama = new TextView(this);
                viewNama.setText(name);
                viewNama.setPadding(5, 1, 5, 1);
                barisTabel.addView(viewNama);

                TextView viewAlamat = new TextView(this);
                viewAlamat.setText(alamat);
                viewAlamat.setPadding(5, 1, 5, 1);
                barisTabel.addView(viewAlamat);

                buttonEdit.add(i, new Button(this));
                buttonEdit.get(i).setId(Integer.parseInt(id));
                buttonEdit.get(i).setTag("Edit");
                buttonEdit.get(i).setText("Edit");
                buttonEdit.get(i).setOnClickListener(this);
                barisTabel.addView(buttonEdit.get(i));

                buttonDelete.add(i, new Button(this));
                buttonDelete.get(i).setId(Integer.parseInt(id));
                buttonDelete.get(i).setTag("Delete");
                buttonDelete.get(i).setText("Delete");
                buttonDelete.get(i).setOnClickListener(this);
                barisTabel.addView(buttonDelete.get(i));

                tabelBiodata.addView(barisTabel, new TableLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));

            }
        }

    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.buttonTambahBiodata) {
            // Toast.makeText(MainActivity.this, "Button Tambah Data",
            // Toast.LENGTH_SHORT).show();

            tambahBiodata();

        } else {
			/*
			 * Melakukan pengecekan pada data array, agar sesuai dengan index
			 * masing-masing button
			 */
            for (int i = 0; i < buttonEdit.size(); i++) {

				/* jika yang diklik adalah button edit */
                if (view.getId() == buttonEdit.get(i).getId()
                        && view.getTag().toString().trim().equals("Edit")) {
                    // Toast.makeText(MainActivity.this, "Edit : " +
                    // buttonEdit.get(i).getId(), Toast.LENGTH_SHORT).show();
                    int id = buttonEdit.get(i).getId();
                    getDataByID(id);

                } /* jika yang diklik adalah button delete */ else if (view.getId() == buttonDelete.get(i).getId()
                        && view.getTag().toString().trim().equals("Delete")) {
                    // Toast.makeText(MainActivity.this, "Delete : " +
                    // buttonDelete.get(i).getId(), Toast.LENGTH_SHORT).show();
                    int id = buttonDelete.get(i).getId();
                    deleteBiodata(id);

                }
            }
        }
    }

    public void deleteBiodata(int id) {

        sqLiteHelper.hapus_biodata(id);

		/* restart acrtivity */
        finish();
        startActivity(getIntent());

    }

    public void getDataByID(int id) {

        String namaEdit = null, alamatEdit = null;

        HashMap<String, String> hashMapBiodata = sqLiteHelper
                .tampil_biodata_berdasarkan_id(id);

        for (int i = 0; i < hashMapBiodata.size(); i++) {
            namaEdit = hashMapBiodata.get("nama");
            alamatEdit = hashMapBiodata.get("alamat");
        }

        LinearLayout layoutInput = new LinearLayout(this);
        layoutInput.setOrientation(LinearLayout.VERTICAL);

        // buat id tersembunyi di alertbuilder
        final TextView viewId = new TextView(this);
        viewId.setText(String.valueOf(id));
        viewId.setTextColor(Color.TRANSPARENT);
        layoutInput.addView(viewId);

        final EditText editNama = new EditText(this);
        editNama.setText(namaEdit);
        layoutInput.addView(editNama);

        final EditText editAlamat = new EditText(this);
        editAlamat.setText(alamatEdit);
        layoutInput.addView(editAlamat);

        AlertDialog.Builder builderEditBiodata = new AlertDialog.Builder(this);
        builderEditBiodata.setTitle("Update Biodata");
        builderEditBiodata.setView(layoutInput);
        builderEditBiodata.setPositiveButton("Update",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String nama = editNama.getText().toString();
                        String alamat = editAlamat.getText().toString();

                        System.out.println("Nama : " + nama + " Alamat : "
                                + alamat);

                        sqLiteHelper.update_biodata(Integer.parseInt(viewId
                                .getText().toString()), editNama.getText()
                                .toString(), editAlamat.getText().toString());

						/* restart acrtivity */
                        finish();
                        startActivity(getIntent());
                    }

                });

        builderEditBiodata.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        builderEditBiodata.show();

    }

    public void tambahBiodata() {
		/* layout akan ditampilkan pada AlertDialog */
        LinearLayout layoutInput = new LinearLayout(this);
        layoutInput.setOrientation(LinearLayout.VERTICAL);

        final EditText editNama = new EditText(this);
        editNama.setHint("Nama");
        layoutInput.addView(editNama);

        final EditText editAlamat = new EditText(this);
        editAlamat.setHint("Alamat");
        layoutInput.addView(editAlamat);

        AlertDialog.Builder builderInsertBiodata = new AlertDialog.Builder(this);
        builderInsertBiodata.setTitle("Insert Biodata");
        builderInsertBiodata.setView(layoutInput);
        builderInsertBiodata.setPositiveButton("Insert",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String nama = editNama.getText().toString();
                        String alamat = editAlamat.getText().toString();

                        System.out.println("Nama : " + nama + " Alamat : "
                                + alamat);

                        sqLiteHelper.tambah_biodata(nama, alamat);
						/* restart acrtivity */
                        finish();
                        startActivity(getIntent());
                    }

                });

        builderInsertBiodata.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        builderInsertBiodata.show();
    }
}
