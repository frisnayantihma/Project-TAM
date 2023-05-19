package com.example.project531.Helper;

import android.content.Context;
import android.widget.Toast;

import com.example.project531.Domain.CoffeDomain;
import com.example.project531.Interface.ChangeNumberItemsListener;

import java.util.ArrayList;

public class ManagementKeranjang {
    private Context context;
    private TinyDBs tinyDBs;

    public ManagementKeranjang(Context context) {
        this.context = context;
        this.tinyDBs = new TinyDBs(context);
    }

    public void insertFood(CoffeDomain item) {
        ArrayList<CoffeDomain> listFood = getListCart();
        boolean existAlready = false;
        int n = 0;
        for (int i = 0; i < listFood.size(); i++) {
            if (listFood.get(i).getTitle().equals(item.getTitle())) {
                existAlready = true;
                n = i;
                break;
            }
        }

        if (existAlready) {
            listFood.get(n).setNumberInCart(item.getNumberInCart());
        } else {
            listFood.add(item);
        }

        tinyDBs.putListObject("ListKeranjang", listFood);
        Toast.makeText(context, "Cart berhasil ditambahkan", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<CoffeDomain> getListCart() {
        return tinyDBs.getListObject("ListKeranjang");
    }

    public void minusNumberFood(ArrayList<CoffeDomain> listfood, int position, ChangeNumberItemsListener changeNumberItemsListener) {
        if (listfood.get(position).getNumberInCart() == 1) {
            listfood.remove(position);
        } else {
            listfood.get(position).setNumberInCart(listfood.get(position).getNumberInCart() - 1);
        }
        tinyDBs.putListObject("ListKeranjang", listfood);
        changeNumberItemsListener.changed();
    }

    public void plusNumberFood(ArrayList<CoffeDomain> listfood, int position, ChangeNumberItemsListener changeNumberItemsListener) {
        listfood.get(position).setNumberInCart(listfood.get(position).getNumberInCart() + 1);
        tinyDBs.putListObject("ListKeranjang", listfood);
        changeNumberItemsListener.changed();
    }

    public Double getTotalFee() {
        ArrayList<CoffeDomain> listfood2 = getListCart();
        double fee = 0;
        for (int i = 0; i < listfood2.size(); i++) {
            fee = fee + (listfood2.get(i).getBayar() * listfood2.get(i).getNumberInCart());
        }
        return fee;
    }
}
