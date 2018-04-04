package com.beefnb.dbdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.beefnb.dbdemo.db.bean.NoteBean;
import com.beefnb.dbdemo.db.dao.NoteDao;
import com.beefnb.dbdemo.db.impl.NoteImpl;

import java.text.DateFormat;
import java.util.Date;
import java.util.UUID;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    private static final DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);

    private EditText edtv;
    private ListView lv;
    private Button btn;

    private NoteDao dao = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtv = findViewById(R.id.edTv);
        lv = findViewById(R.id.lv);
        btn = findViewById(R.id.btnAdd);
        btn.setOnClickListener(this);
        dao = new NoteImpl();
    }


    @Override
    public void onClick(View v) {
        String text = edtv.getText().toString();
        if (!text.isEmpty()){
            dao.insert(new NoteBean(UUID.randomUUID().toString(),text,df.format(new Date())));
            edtv.setText("");
        }
    }



}
