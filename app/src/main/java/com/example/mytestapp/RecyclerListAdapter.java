package com.example.mytestapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerListAdapter extends RecyclerView.Adapter<RecyclerListAdapter.Datahold> {
    private Context context;
    private ArrayList<dataModel> dataModelArrayList;
    dataModel dataModel1=new dataModel();

    public RecyclerListAdapter(Context context, ArrayList<dataModel> dataModelArrayList) {
        this.context = context;
        this.dataModelArrayList = dataModelArrayList;
    }

    @NonNull
    @Override
    public Datahold onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_adapter_list, viewGroup, false);

        return new Datahold(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final Datahold datahold, int i) {

        datahold.txtName.setText(dataModelArrayList.get(i).getName());
        String quantity= String.valueOf(dataModelArrayList.get(i).getQuan());
        datahold.edtqty.setText(quantity);
        final String price= String.valueOf(dataModelArrayList.get(i).getPrice());
        datahold.edtprice.setText(price);

        datahold.edtqty.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

               String quantity= String.valueOf(datahold.edtqty.getText());
               if (quantity.equalsIgnoreCase("")){
                   quantity= String.valueOf(1);
               }
                dataModel1.setQuan(Integer.parseInt(quantity));

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }


    @Override
    public int getItemCount() {
        return dataModelArrayList.size();
    }

    public class Datahold extends RecyclerView.ViewHolder {
        private TextView txtName, cal;
        private EditText edtqty,edtprice;
        public Datahold(@NonNull View itemView) {
            super(itemView);
            txtName=itemView.findViewById(R.id.name);
            edtprice=itemView.findViewById(R.id.price);
            edtqty=itemView.findViewById(R.id.qty);
            cal = itemView.findViewById(R.id.cal);


        }
    }
    public  double grandTotal(){
        double total=0.0;
        for (int i=0;i<dataModelArrayList.size();i++){
            total=dataModelArrayList.get(i).getQuan()*dataModelArrayList.get(i).getPrice();

        }
        return total;
    }
}
