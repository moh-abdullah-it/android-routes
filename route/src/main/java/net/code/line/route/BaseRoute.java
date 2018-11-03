package net.code.line.route;

import android.content.Context;
import android.content.Intent;
import android.view.View;

/**
 * Android Routes
 * easy way to use intent
 * @Auth Mohamed abdullah
 * @email moh.abdullah.it@gmail.com
 * @data 27/10/2018
 */
public class BaseRoute {
    protected Intent intent;
    protected Context context;

    /**
     * @param context
     */
    public BaseRoute(Context context) {
        this.context = context;
    }

    /**
     * @param cls
     * @return Route
     */
    public BaseRoute to(Class<?> cls){
        this.intent = new Intent(this.context,cls);
        return this;
    }

    /**
     * @param key
     * @param value
     * @return Route
     */
    public BaseRoute withData(String key, String value) {
        this.intent.putExtra(key, value);
        return this;
    }

    /**
     * @param key
     * @param value
     * @return Route
     */
    public BaseRoute withData(String key, int value) {
        this.intent.putExtra(key, value);
        return this;
    }

    /**
     * start activity
     */
    public void start() {
        this.context.startActivity(this.intent);
    }

    /**
     * start if this middleware is true
     * @param middleware
     */
    public void start(boolean middleware) {
        if(middleware){
            this.context.startActivity(this.intent);
        }
    }

    public void startOnClick(View view) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                start();
            }
        });
    }

    public void startOnClick(View view, final boolean middleware) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(middleware){
                   start();
               }
            }
        });
    }

    /**
     * @param  key
     * @return String
     */
    public String getString(String key)
    {
        return this.intent.getStringExtra(key);
    }

    /**
     * @param key
     * @return int
     */
    public int getInt(String key)
    {
        return this.intent.getIntExtra(key,0);
    }

    /**
     * @param key
     * @return boolean
     */
    public boolean has(String key)
    {
        return this.intent.hasExtra(key);
    }
}