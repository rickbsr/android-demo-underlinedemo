package com.codingbydumbbell.underlinedemo;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private TextView tv_contract1;
    private TextView tv_contract2;
    private TextView tv_contract3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();

        // 使用 Html.fromHtml()
        tv2.setText(Html.fromHtml("<u>" + tv2.getText().toString() + "</u>"));

        // 使用 TextView 的 Paint 的属性
        tv3.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG); // 底線
        tv3.getPaint().setAntiAlias(true); // 反鋸齒

        // 使用 SpannableString 類別
        SpannableString strTv4 = new SpannableString(tv4.getText().toString());
        strTv4.setSpan(new UnderlineSpan(), 0, strTv4.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv4.setText(strTv4);

        SpannableString strContract3 = new SpannableString(tv_contract3.getText().toString());
        strContract3.setSpan(new UnderlineSpan(), 3, 9, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        strContract3.setSpan(new ForegroundColorSpan(Color.BLUE), 3, 9, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv_contract3.setText(strContract3);
    }

    private void findViews() {
        tv1 = findViewById(R.id.textView1);
        tv2 = findViewById(R.id.textView2);
        tv3 = findViewById(R.id.textView3);
        tv4 = findViewById(R.id.textView4);
        tv_contract1 = findViewById(R.id.tv_contract1);
        tv_contract2 = findViewById(R.id.tv_contract2);
        tv_contract3 = findViewById(R.id.tv_contract3);
    }
}
