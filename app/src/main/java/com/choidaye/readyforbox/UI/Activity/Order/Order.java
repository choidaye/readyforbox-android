package com.choidaye.readyforbox.UI.Activity.Order;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.choidaye.readyforbox.R;

public class Order extends AppCompatActivity {

    ImageButton btnItemDown,btnItemUp,btnPersonDown,
                btnPersonUp,btnShipUP,btnShipDown,btnAddressUP,btnAddressDown,
                btnPayUP, btnPayDown,btnLastUp, btnLastDown;
    RelativeLayout itemBefore, personBefore,shippingBefore,addressBefore,payBefore,lastBefore;
    LinearLayout itemAfter, personAfter,shippingAfter,addressAfter,payAfter,lastAfter;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        btnItemDown = (ImageButton)findViewById(R.id.btn_order_item_view_down);
        btnItemUp = (ImageButton)findViewById(R.id.btn_order_item_view_up);
        btnPersonDown = (ImageButton)findViewById(R.id.btn_person_item_view_down);
        btnPersonUp = (ImageButton)findViewById(R.id.btn_person_item_view_up);
        btnShipDown = (ImageButton)findViewById(R.id.btn_shpping_item_view_down);
        btnShipUP = (ImageButton)findViewById(R.id.btn_shpping_item_view_up);
        btnAddressDown = (ImageButton)findViewById(R.id.btn_regular_item_view_down);
        btnAddressUP = (ImageButton)findViewById(R.id.btn_regular_item_view_up);
        btnPayUP = (ImageButton)findViewById(R.id.btn_pay_item_view_up);
        btnPayDown = (ImageButton)findViewById(R.id.btn_pay_item_view_down);
        btnLastDown = (ImageButton)findViewById(R.id.btn_last_item_view_down);
        btnLastUp = (ImageButton)findViewById(R.id.btn_last_item_view_up);

        itemBefore = (RelativeLayout)findViewById(R.id.order_item_view_before_click);
        itemAfter = (LinearLayout)findViewById(R.id.order_item_view_after_click);

        personBefore = (RelativeLayout)findViewById(R.id.order_person_view_before_click);
        personAfter = (LinearLayout)findViewById(R.id.order_person_view_after_click);

        shippingBefore = (RelativeLayout)findViewById(R.id.order_view_shipping_before_click);
        shippingAfter = (LinearLayout)findViewById(R.id.order_shipping_view_after_click);

        addressBefore = (RelativeLayout)findViewById(R.id.order_address_view_before_click);
        addressAfter = (LinearLayout)findViewById(R.id.order_address_view_after_click);

        payBefore = (RelativeLayout)findViewById(R.id.order_pay_view_before_click);
        payAfter = (LinearLayout)findViewById(R.id.order_pay_view_after_click);

        lastBefore= (RelativeLayout)findViewById(R.id.order_last_view_before_click);
        lastAfter = (LinearLayout)findViewById(R.id.order_last_view_after_click);



    }

    ImageButton.OnClickListener onClickListener = new ImageButton.OnClickListener(){
        @Override
        public void onClick(View view){
            switch (view.getId()){
                case R.id.btn_order_item_view_down:
                    itemBefore.setVisibility(RelativeLayout.INVISIBLE);
                    itemAfter.setVisibility(LinearLayout.VISIBLE);
                    break;
                case R.id.btn_order_item_view_up:
                    itemAfter.setVisibility(LinearLayout.INVISIBLE);
                    itemBefore.setVisibility(RelativeLayout.VISIBLE);
                    break;
                case  R.id.btn_person_item_view_down:
                    personBefore.setVisibility(RelativeLayout.INVISIBLE);
                    personAfter.setVisibility(LinearLayout.VISIBLE);
                    break;
                case R.id.btn_person_item_view_up:
                    personAfter.setVisibility(LinearLayout.INVISIBLE);
                    personBefore.setVisibility(RelativeLayout.VISIBLE);
                    break;
                case R.id.btn_shpping_item_view_down:
                    shippingAfter.setVisibility(LinearLayout.VISIBLE);
                    shippingBefore.setVisibility(RelativeLayout.INVISIBLE);
                    break;
                case R.id.btn_shpping_item_view_up:
                    shippingAfter.setVisibility(LinearLayout.INVISIBLE);
                    shippingBefore.setVisibility(RelativeLayout.VISIBLE);
                    break;
                case R.id.btn_regular_item_view_down:
                    addressAfter.setVisibility(LinearLayout.VISIBLE);
                    addressBefore.setVisibility(RelativeLayout.INVISIBLE);
                    break;
                case R.id.btn_regular_item_view_up:
                    addressAfter.setVisibility(LinearLayout.INVISIBLE);
                    addressBefore.setVisibility(RelativeLayout.VISIBLE);
                    break;
                case R.id.btn_pay_item_view_down:
                    payBefore.setVisibility(RelativeLayout.INVISIBLE);
                    payAfter.setVisibility(LinearLayout.VISIBLE);
                    break;
                case R.id.btn_pay_item_view_up:
                    payAfter.setVisibility(LinearLayout.INVISIBLE);
                    payBefore.setVisibility(RelativeLayout.VISIBLE);
                    break;
                case R.id.btn_last_item_view_up:
                    lastAfter.setVisibility(LinearLayout.INVISIBLE);
                    lastBefore.setVisibility(RelativeLayout.VISIBLE);
                    break;
                case R.id.btn_last_item_view_down:
                    lastBefore.setVisibility(RelativeLayout.INVISIBLE);
                    lastAfter.setVisibility(LinearLayout.VISIBLE);
                    break;


            }
        }
    };

}
