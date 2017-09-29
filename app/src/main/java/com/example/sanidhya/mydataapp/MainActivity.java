package com.example.sanidhya.mydataapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    private static final String Warning_Ins= "Can't add empty TODO";
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
        String product = myeditText.getText().toString().trim();
        if(!(product.equals("") || product.equals(Warning_Ins) )){
        Products products = new Products(product);
        dbHandler.addProducts(products);

        printDatabase();
        }else{
            myeditText.setText(Warning_Ins);
        }
    }

    public void deleteButtonClicked(View view){
        String inputText = myeditText.getText().toString();
        dbHandler.deleteProduct(inputText);
        printDatabase();
    }
}
