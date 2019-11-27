package com.example.mytestapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private double total=0.0;
    private ArrayList<dataModel> dataModelArrayList;
    private RecyclerView recyclerView;
    private RecyclerListAdapter adapter;
    dataModel dataModel1;
    TextView txttotal;

    Button btndone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txttotal=findViewById(R.id.total);
        btndone=findViewById(R.id.btnDone);
        dataModelArrayList=new ArrayList<>();
        recyclerView =
                (RecyclerView) findViewById(R.id.my_recycler_view);

        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        dataModelArrayList.add(new dataModel("Tomato",10.0,3));
        dataModelArrayList.add(new dataModel("Potato",20.0,2));
        dataModelArrayList.add(new dataModel("kanda",30.0,1));

        adapter = new RecyclerListAdapter(getBaseContext(),dataModelArrayList);
        recyclerView.setAdapter(adapter);

        btndone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                total=grandTotal();
                String totalofitem= String.valueOf(total);
                txttotal.setText("Total : " + totalofitem);
                

            }
        });
    }
    public  double grandTotal(){
        double total=0.0;
        for (int i=0;i<dataModelArrayList.size();i++){

            total +=dataModelArrayList.get(i).getQuan()*dataModelArrayList.get(i).getPrice();

        }
        return total;
    }
}
