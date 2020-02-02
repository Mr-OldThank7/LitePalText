package com.example.litepaltext;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import org.litepal.LitePal;
import org.litepal.tablemanager.Connector;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText Edit_Retrieve_name,Edit_Retrieve_author,Edit_Retrieve_price,Edit_Retrieve_pages;
    private EditText Edit_add_name,Edit_add_author,Edit_add_price,Edit_add_pages;
    private EditText Edit_detele_name;
    private String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Edit_add_name = (EditText) findViewById(R.id.Edit_name);
        Edit_add_author = (EditText) findViewById(R.id.Edit_author);
        Edit_add_price = (EditText) findViewById(R.id.Edit_price);
        Edit_add_pages = (EditText) findViewById(R.id.Edit_pages);

        Edit_Retrieve_name = (EditText)findViewById(R.id.Retrieve_name);
        Edit_Retrieve_author = (EditText)findViewById(R.id.Retrieve_author);
        Edit_Retrieve_price = (EditText)findViewById(R.id.Retrieve_price);
        Edit_Retrieve_pages = (EditText)findViewById(R.id.Retrieve_pages);

        findViewById(R.id.create_database).setOnClickListener(this);
        findViewById(R.id.addData).setOnClickListener(this);
        findViewById(R.id.Retrieve_Btn_data).setOnClickListener(this);
        findViewById(R.id.btn_Detele).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.create_database:
                create_database();
                break;
            case R.id.addData:
                add();
                break;
            case R.id.Retrieve_Btn_data:
                Retrieve();
                break;
            case R.id.btn_Detele:
                Detele_Data();
        }
    }

    private void Detele_Data() {
        Edit_detele_name = (EditText) findViewById(R.id.detele_name);
        LitePal.deleteAll(Book.class,"name=?",Edit_detele_name.getText().toString());
        Toast.makeText(this, "<以为您删除>", Toast.LENGTH_SHORT).show();

    }

    private void Retrieve() {
        String name = Edit_Retrieve_name.getText().toString().trim();
        List<Book> books = LitePal.where("name=?",name).find(Book.class);
        for (Book book:books) {
            Edit_Retrieve_name.setText(book.getName());
            Edit_Retrieve_author.setText(book.getAuthor());
            Edit_Retrieve_price.setText(book.getPrice() + "");
            Edit_Retrieve_pages.setText(book.getPages() + "");
            Toast.makeText(this, "<读取完毕>", Toast.LENGTH_SHORT).show();
        }
    }

    private void add() {
        Book book = new Book();
        book.setName(Edit_add_name.getText().toString());
        book.setAuthor(Edit_add_author.getText().toString());
        book.setPages(Integer.valueOf(Edit_add_pages.getText().toString()));
        book.setPrice(Integer.valueOf(Edit_add_price.getText().toString()));
        book.save();
        Toast.makeText(this, "添加完成......", Toast.LENGTH_SHORT).show();

        Edit_add_name.setText("");
        Edit_add_author.setText("");
        Edit_add_price.setText("");
        Edit_add_pages.setText("");

    }

    private void create_database() {
        Connector.getDatabase();
        Toast.makeText(MainActivity.this, "000", Toast.LENGTH_SHORT).show();
    }
}
