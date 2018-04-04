package com.beefnb.dbdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
    private RecyclerView lv;
    private Button btnAdd,btnShow;

    private NoteDao dao = null;

    private NoteAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtv = findViewById(R.id.edTv);

        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);
        btnShow = findViewById(R.id.btnShow);
        btnShow.setOnClickListener(this);

        dao = new NoteImpl();

        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        lv = findViewById(R.id.lv);
        adapter = new NoteAdapter();
        lv.setAdapter(adapter);
        lv.setLayoutManager(manager);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAdd:
                String text = edtv.getText().toString();
                if (!text.isEmpty()){
                    dao.insert(new NoteBean(UUID.randomUUID().toString(),text,df.format(new Date())));
                    edtv.setText("");
                }
                break;
            case R.id.btnShow:
                adapter.update(dao.query());
                break;
            default:
                break;
        }
    }




}
