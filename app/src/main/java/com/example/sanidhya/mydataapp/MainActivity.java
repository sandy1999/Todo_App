package com.example.sanidhya.mydataapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    EditText myeditText;
    TextView myText;
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myeditText = (EditText) findViewById(R.id.myeditText);
        myText = (TextView) findViewById(R.id.textView);

        dbHandler = new MyDBHandler(this,null,null,1);
        printDatabase();
    }

    public void printDatabase(){
        String dbString = dbHandler.databaseToString();
        myText.setText(dbString);
        myeditText.setText("");
    }

    public void addButtonClicked(View view){
        Products products = new Products(myeditText.getText().toString());
        dbHandler.addProducts(products);
        printDatabase();
//        String Text = myeditText.getText().toString();
//        myText.setText(Text);
    }

    public void deleteButtonClicked(View view){
        String inputText = myeditText.getText().toString();
        dbHandler.deleteProduct(inputText);
        printDatabase();
//        myText.setText("deleteButtonWorks");
    }
}
