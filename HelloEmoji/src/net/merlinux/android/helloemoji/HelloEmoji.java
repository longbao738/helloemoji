
package net.merlinux.android.helloemoji;

import android.os.Bundle;
import android.app.Activity;
import android.util.TypedValue;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class HelloEmoji extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StringBuilder sb = new StringBuilder();
        sb.append("Indicator").append(Character.toChars(0x1F1EF));
        sb.append("Red apple").append(Character.toChars(0x1F34E));

        final TextView tvSize = (TextView)findViewById(R.id.textview_size);
        final TextView tvContent = (TextView)findViewById(R.id.textview_content);
        tvContent.setText(sb.toString());
        tvSize.setText("" + tvContent.getTextSize());

        Button btnInc = (Button)findViewById(R.id.button_increase);
        btnInc.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                float size = tvContent.getTextSize();
                size++;
                tvContent.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
                tvSize.setText("" + size);
            }
        });
        Button btnDec = (Button)findViewById(R.id.button_decrease);
        btnDec.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                float size = tvContent.getTextSize();
                size--;
                if (size > 0) {
                    tvContent.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
                    tvSize.setText("" + size);
                }
            }
        });
    }

}
