package com.calculator.ching.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.calculator.ching.calculator.View.Text_View;
import com.calculator.ching.calculator.calculate.calculate;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements View.OnClickListener, View.OnLongClickListener {
    private Text_View expressions_view, result_view;
    private Button one_but, two_but, three_but, four_but, five_but, six_but, seven_but, eight_but, nine_but, zero_but, point_but;
    private Button plus_but, subtract_but, multiply_but, divide_but, left_bracket_but, right_bracket_but, delete_but, equal_but;
    boolean b;
    boolean isNewStart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expressions_view = $(R.id.expressions_view);
        result_view = $(R.id.result_view);

        one_but = $(R.id.one_but);
        one_but.setOnClickListener(this);
        two_but = $(R.id.two_but);
        two_but.setOnClickListener(this);
        three_but = $(R.id.three_but);
        three_but.setOnClickListener(this);
        four_but = $(R.id.four_but);
        four_but.setOnClickListener(this);
        five_but = $(R.id.five_but);
        five_but.setOnClickListener(this);
        six_but = $(R.id.six_but);
        six_but.setOnClickListener(this);
        seven_but = $(R.id.seven_but);
        seven_but.setOnClickListener(this);
        eight_but = $(R.id.eight_but);
        eight_but.setOnClickListener(this);
        nine_but = $(R.id.nine_but);
        nine_but.setOnClickListener(this);
        zero_but = $(R.id.zero_but);
        zero_but.setOnClickListener(this);
        point_but = $(R.id.point_but);
        point_but.setOnClickListener(this);

        plus_but = $(R.id.plus_but);
        plus_but.setOnClickListener(this);
        subtract_but = $(R.id.subtract_but);
        subtract_but.setOnClickListener(this);
        multiply_but = $(R.id.multiply_but);
        multiply_but.setOnClickListener(this);
        divide_but = $(R.id.divide_but);
        divide_but.setOnClickListener(this);
        left_bracket_but = $(R.id.left_bracket_but);
        left_bracket_but.setOnClickListener(this);
        right_bracket_but = $(R.id.right_bracket_but);
        right_bracket_but.setOnClickListener(this);
        delete_but = $(R.id.delete_but);
        delete_but.setOnClickListener(this);
        delete_but.setOnLongClickListener(this);
        equal_but = $(R.id.equal_but);
        equal_but.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch(view.getId()){
            case R.id.one_but:
            case R.id.two_but:
            case R.id.three_but:
            case R.id.four_but:
            case R.id.five_but:
            case R.id.six_but:
            case R.id.seven_but:
            case R.id.eight_but:
            case R.id.nine_but:
            case R.id.zero_but:
                if (isNewStart) {
                    expressions_view.setText("");
                }
                isNewStart = false;
                expressions_view.append(((Button)view).getText());
                break;

            case R.id.point_but:
                b = isPoint(expressions_view.getText().toString());
                if (!b) {
                    return;
                }
                isNewStart = false;
                expressions_view.append(((Button)view).getText());
                break;

            case R.id.plus_but:
            case R.id.subtract_but:
            case R.id.multiply_but:
            case R.id.divide_but:
                expressions_view.setText(fix(expressions_view.getText().toString(),false));
                isNewStart = false;
                b = isOp(expressions_view.getText().toString());
                if (!b) {
                    String s = expressions_view.getText().toString();
                    if (s.length() < 3) {
                        return;
                    }
                    String s1 = s.substring(0, s.length() - 3);
                    expressions_view.setText(s1);
                }
                expressions_view.append(" "+((Button)view).getText()+" ");
                break;

            case R.id.delete_but:
                deleteOneByOne(expressions_view.getText().toString());
                break;

            case R.id.equal_but:
                expressions_view.setText(fix(expressions_view.getText().toString(),true));
                isNewStart = true;
                List<String> list = calculate.test3(calculate.test2(expressions_view.getText().toString()));
                System.out.println(ListToString(list));
                result_view.setText(ListToString(list));
                break;
        }
    }

    public String fix(String s,boolean isOPandPoint) {
        String s1;
        if (s.equals("") || s.equals(null)) {                // 如果是空的
            return null;
        }
        if (!s.contains(" ") && !s.contains(".")) {          // 如果既没有运算符也没有“.”
            return s;
        }
        if (!isOPandPoint){
            if (s.contains(".")) {
                s1 = s.substring(s.length() - 1,s.length());
                if (s1.equals(".")){
                    s = s.substring(0,s.length()-1);
                }
            }
        }else if (isOPandPoint){
            String s2 = s.substring(s.length()-1,s.length());
            if (s2.equals(" ")){
                s = s.substring(0,s.length()-3);
            }else if (s2.equals(".")){
                s = s.substring(0,s.length()-1);
            }
        }

//        if (isOPandPoint){
//            if (s.contains(" ")) {                // 如果是运算符
//                s1 = s.substring(s.length() - 3,s.length());
//                System.out.println("有运算符" + s1);
//            }
//        }
        return s;
    }

    //判断能不能输入点号
    public boolean isPoint(String s) {
        String str;
        if (s.equals("") || s.equals(null)) { // 如果是空的
            return false;
        }
        if (s.contains(" ")) {               //判断有没有运算符(获取后要算的数字)
            int indexEnd = s.lastIndexOf(" ");
            str = s.substring(indexEnd + 1);
            if (str.contains(".") || !str.matches("\\d+")) {
                return false;
            }
        }
        if (s.contains(".") && !s.contains(" ")) {
            return false;
        }
        return true;
    }

    //判断第一个有没有数字以及判断最后一个是不是运算符
    public boolean isOp(String s) {
        String str = "";
        if (s.equals("") || s.equals(null)) {    //如果是空的...
            return false;
        }
        if (s.length() == 1 || s.length() == 2) {           //如果只有一个字符串...
            return true;
        } else if (s.length() >= 3) {      //如果大于等于三个字符串...
            str = s.substring(s.length() - 2, s.length() - 1);
            if (str.equals("+") || str.equals("-") ||
                    str.equals("*") || str.equals("/")) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    //逐一删除的方法（待完善）
    public void deleteOneByOne(String s) {
        if (s.equals("") || s.equals(null)) {
            return;
        }
        String op = s.substring(s.length() - 1);
        if (op.matches("\\s")) {
            expressions_view.setText(s.substring(0, s.length() - 3));
            System.out.println("OP:" + op);
            return;
        }
        expressions_view.setText(s.substring(0, s.length() - 1));
    }

    //List转为String
    public String ListToString(List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : list) {
            stringBuilder.append(s);
        }
        return PointAfter(stringBuilder.toString());
    }

    //判断小数点之后是不是全是0，如是就包括小数点去掉
    public String PointAfter(String s){
        int index = s.indexOf(".");
        String str ;
        String s1 = s.substring(index+1);
        if (s1.length() == 1){
            if (s1.equals("0")){
                str = s.substring(0,index);
                System.out.println("点号之后："+str);
                return str;
            }
        }
        return s;
    }

    @Override  //长按清除键全部删除
    public boolean onLongClick(View view) {
        expressions_view.setText("");
        result_view.setText("");
        return false;
    }

}
