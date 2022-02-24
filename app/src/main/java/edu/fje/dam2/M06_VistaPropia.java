package edu.fje.dam2;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Classe que demostra el funcionament de Canvas.
 * Dibuixa directament sobre una View
 * @author sergi.grau@fje.edu
 * @version 5.0 27.01.2020
 */

class M06_VistaPropia extends View
{
    private float x;
    private float y;
    private String cadena;

    private int color;
    public M06_VistaPropia(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.M06_VistaPropia,
                0, 0);

        try {
            x = a.getFloat(R.styleable.M06_VistaPropia_x, 0);
            cadena = a.getString(R.styleable.M06_VistaPropia_cadena);

        } finally {
            a.recycle();
        }
    }

    //Metodo que dibuja el SIMON
    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(color);
       // canvas.drawRect(x, y, 750  , 600, paint);

        paint.setColor(Color.BLACK);
        canvas.drawCircle(540,1000,160,paint);
        paint.setTextSize(60);
        canvas.drawText("Simon Game!", 350, 250, paint);
        float x = (getWidth() - getHeight() / 2) ;
        float y = getHeight() / 4;

        RectF oval = new RectF( x, y,
                getWidth() - x, getHeight() - y);
        paint.setStrokeWidth(180);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLUE);
        //paint.setShadowLayer(3,3,3,color);
        canvas.drawArc(oval, 0F, 90F, false, paint);
        paint.setColor(Color.GREEN);
        canvas.drawArc(oval, 90F, 90F, false, paint);
        paint.setColor(Color.RED);
        canvas.drawArc(oval, 180F, 90F, false, paint);

        //paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.YELLOW);
        canvas.drawArc(oval, 270F, 90F, false, paint);


    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public void setX(float x) {
        this.x = x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public void setY(float y) {
        this.y = y;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

}