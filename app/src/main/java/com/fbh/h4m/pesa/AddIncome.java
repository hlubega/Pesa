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
 * Created by fbh on 26/03/2015.
 */
public class AddIncome extends ActionBarActivity implements View.OnClickListener{

    EditText edDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_income);
        edDate = (EditText) findViewById(R.id.edDateInc);
        edDate.setOnClickListener(this);

        Spinner payer_spinner = (Spinner) findViewById(R.id.spinner_inc);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.income_spinner, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        payer_spinner.setAdapter(adapter);
    }
    Calendar myCalender = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener(){

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            myCalender.set(Calendar.YEAR, year);
            myCalender.set(Calendar.MONTH, monthOfYear);
            myCalender.set(Calendar.DAY_OF_WEEK, dayOfMonth);
            updateField();
        }

        private void updateField() {

            String myFormat = "MM/dd/yy";
            SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.ENGLISH);
            edDate.setText(sdf.format(myCalender.getTime()));
        }
    };

    @Override
    public void onClick(View v) {
    new DatePickerDialog(AddIncome.this, date, myCalender.get(Calendar.YEAR),myCalender.get(Calendar.MONTH), myCalender.get(Calendar.DAY_OF_WEEK)).show();
    }


}
