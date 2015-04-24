package com.fbh.h4m.pesa;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


/**
 * Created by fbh on 03/03/2015.
 */
public class AddExpense extends ActionBarActivity implements View.OnClickListener{

     EditText expDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_expense);
        expDate = (EditText) findViewById(R.id.edDateExp);
        expDate.setOnClickListener(this);

        Spinner stat_spinner = (Spinner) findViewById(R.id.spinner_clearedExp);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.status_spinner, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        stat_spinner.setAdapter(adapter);

        Spinner cat_spinner = (Spinner) findViewById(R.id.spinner_Category);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.expenseCategory_spinner, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_item);
        cat_spinner.setAdapter(adapter1);

}
Calendar myCalender = Calendar.getInstance();

    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener(){

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            myCalender.set(Calendar.YEAR,year);
            myCalender.set(Calendar.MONTH, monthOfYear);
            myCalender.set(Calendar.DAY_OF_WEEK, dayOfMonth);
            updateLabel();
        }
    };

    @Override
    public void onClick(View v) {
        new DatePickerDialog(AddExpense.this, date, myCalender.get(Calendar.YEAR), myCalender.get(Calendar.MONTH), myCalender.get(Calendar.DAY_OF_MONTH)).show();
    }

    private void updateLabel() {
    String myFormat = "MM/dd/yy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.ENGLISH);
        expDate.setText(sdf.format(myCalender.getTime()));
    }
}
