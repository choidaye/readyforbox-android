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

    ImageButton btnItemDown,btnItemUp,btnPersonDown,btnPersonUp;
    RelativeLayout itemBefore, personBefore;
    LinearLayout itemAfter, personAfter;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        btnItemDown = (ImageButton)findViewById(R.id.btn_order_item_view_down);
        btnItemUp = (ImageButton)findViewById(R.id.btn_order_item_view_up);
        btnPersonDown = (ImageButton)findViewById(R.id.btn_person_item_view_down);
        btnPersonUp = (ImageButton)findViewById(R.id.btn_person_item_view_up);

        itemBefore = (RelativeLayout)findViewById(R.id.order_item_view_before_click);
        itemAfter = (LinearLayout)findViewById(R.id.order_item_view_after_click);

        personBefore = (RelativeLayout)findViewById(R.id.order_person_view_before_click);
        personAfter = (LinearLayout)findViewById(R.id.order_person_view_after_click);



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
            }
        }
    };

}
