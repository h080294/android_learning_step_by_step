package com.johnhao.demo.activity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.johnhao.demo.R;
import com.johnhao.demo.util.MyDatabaseHelper;

public class SQLiteActivity extends BaseActivity {

    private Button btn;
    private Button add_data;
    private Button update_data;
    private Button delete_data;
    private Button query_data;
    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        setTitle("SQLite");
        dbHelper = new MyDatabaseHelper(this, "BookStore.db", null, 2);
        btn = findViewById(R.id.btn_sql_create);
        add_data = findViewById(R.id.btn_sql_add_data);
        update_data = findViewById(R.id.btn_sql_update_data);
        delete_data = findViewById(R.id.btn_sql_delete_data);
        query_data = findViewById(R.id.btn_sql_query_data);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.getWritableDatabase();
            }
        });

        // 添加数据
        add_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getReadableDatabase();
                ContentValues values = new ContentValues();
                values.put("name", "The perfect Code");
                values.put("author", "John Hao");
                values.put("pages", 1802);
                values.put("price", 79.99);
                db.insert("Book", null, values);
                values.clear();
                values.put("name", "Travel in Code world2");
                values.put("author", "John Hao");
                values.put("pages", 300);
                values.put("price", 26.73);
                db.insert("Book", null, values);
            }
        });

        // 更新数据
        // update，第一个参数表的名字，第二参数是更新的数据，第三、四个参数用于约束，例子中的name = ?相当于SQL中的where部分，表示为要更新name=?的行
        update_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("price", 254.23);
                db.update("Book", values, "name = ?", new String[]{"Travel in Code world2"});
            }
        });

        // 删除数据
        delete_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.delete("Book", "pages > ?", new String[]{"500"});
            }
        });

        // query查询
        query_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                Cursor cursor = db.query("Book",null,null,null,null,null,null);
                if (cursor.moveToFirst()) {
                    do {
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        String author = cursor.getString(cursor.getColumnIndex("author"));
                        int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                        double price = cursor.getDouble(cursor.getColumnIndex("price"));
                        Log.d("SQLiteActivity", "name: " + name);
                        Log.d("SQLiteActivity", "author: " + author);
                        Log.d("SQLiteActivity", "pages: " + pages);
                        Log.d("SQLiteActivity", "price: " + price);
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }
        });
    }
}
