package com.beefnb.dbdemo.db.impl;

import android.content.ContentValues;
import android.database.Cursor;

import com.beefnb.dbdemo.db.bean.NoteBean;
import com.beefnb.dbdemo.db.dao.NoteDao;
import com.beefnb.dbdemo.db.table.NoteTable;

import java.util.ArrayList;
import java.util.List;


public class NoteImpl extends BaseImpl implements NoteDao {

    private static final String TAG = NoteImpl.class.getSimpleName();

    @Override
    public void insert(NoteBean noteBean) {
        db.insert(NoteTable.TABLE_NAME,null,buildContentValues(noteBean));
    }

    @Override
    public void delete(NoteBean noteBean) {

    }

    @Override
    public void update(NoteBean noteBean) {

    }

    @Override
    public List<NoteBean> query() {
        List<NoteBean> list = new ArrayList<>();
        Cursor c = db.rawQuery(NoteTable.SELECT_ALL,new String[]{});
        while (c.moveToNext()){
            list.add(getCursor(c));
        }
        return list;
    }

    @Override
    public ContentValues buildContentValues(NoteBean noteBean) {
        ContentValues cv = new ContentValues();
        cv.put(NoteTable.ID,noteBean.getId());
        cv.put(NoteTable.CONTENT,noteBean.getContent());
        cv.put(NoteTable.TIME,noteBean.getTime());
        return cv;
    }

    private NoteBean getCursor(Cursor cursor){
        NoteBean result = new NoteBean();
        result.setContent(cursor.getString(cursor.getColumnIndex(NoteTable.CONTENT)));
        result.setTime(cursor.getString(cursor.getColumnIndex(NoteTable.TIME)));
        result.setId(cursor.getString(cursor.getColumnIndex(NoteTable.ID)));
        return result;
    }

//    @Override
//    public void add(OrderResult orderResult) {
//        ContentValues cv = new ContentValues();
//        cv.put(OrderTable.BIZ_ORDER_NUMBER, orderResult.getBizOrderNumber());
//        cv.put(OrderTable.WALLET_TYPE, orderResult.getWalletType());
//        cv.put(OrderTable.DISCOUNT_LIST, orderResult.getDiscountList());
//        cv.put(OrderTable.TXN_STATUS, orderResult.getTxnStatus());
//        cv.put(OrderTable.TOTAL_SRCAMT, orderResult.getTotalSrcAmt());
//        cv.put(OrderTable.PAY_ACCOUNT, orderResult.getPayAccount());
//        cv.put(OrderTable.WALLET_SERIALNUMBER, orderResult.getWalletSerialNumber());
//        cv.put(OrderTable.COMPLETED_TIME, orderResult.getCompletedTime());
//        db.insert(OrderTable.TABLE_NAME,null,cv);
//    }
//
//
//    @Override
//    public void delete(OrderResult orderResult) {
//
//    }
//
//    @Override
//    public void update(OrderResult orderResult) {
//        ContentValues cv = new ContentValues();
////        cv.put(OrderTable.BIZ_ORDER_NUMBER, orderResult.getBizOrderNumber());
//        cv.put(OrderTable.WALLET_TYPE, orderResult.getWalletType());
//        cv.put(OrderTable.DISCOUNT_LIST, orderResult.getDiscountList());
//        cv.put(OrderTable.TXN_STATUS, orderResult.getTxnStatus());
//        cv.put(OrderTable.TOTAL_SRCAMT, orderResult.getTotalSrcAmt());
//        cv.put(OrderTable.PAY_ACCOUNT, orderResult.getPayAccount());
//        cv.put(OrderTable.WALLET_SERIALNUMBER, orderResult.getWalletSerialNumber());
//        cv.put(OrderTable.COMPLETED_TIME, orderResult.getCompletedTime());
//        db.update(OrderTable.TABLE_NAME,cv,OrderTable.BIZ_ORDER_NUMBER+"=?",new String[]{orderResult.getBizOrderNumber()});
//    }
//
//    @Override
//    public List<OrderResult> query(){
//        List<OrderResult> list = new ArrayList<>();
//        Cursor c = db.rawQuery(OrderTable.SQL_QUERY,new String[]{});
//        while (c.moveToNext()){
//            list.add(getCursor(c));
//        }
//        return list;
//    }
//
//    @Override
//    public List<OrderResult> query(String time) {
//        List<OrderResult> list = new ArrayList<>();
//        Cursor c = db.rawQuery(OrderTable.SQL_QUERY_TIME,new String[]{time+"%"});
//        while (c.moveToNext()){
//            list.add(getCursor(c));
//        }
//        return list;
//    }
//
//


}
