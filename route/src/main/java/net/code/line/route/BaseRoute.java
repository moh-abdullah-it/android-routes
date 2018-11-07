package net.code.line.route;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.view.View;

/**
 * Android Routes
 * easy way to use intent
 *
 * @Auth Mohamed abdullah
 * @email moh.abdullah.it@gmail.com
 * @data 27/10/2018
 */
public class BaseRoute {
    private Intent intent;
    protected Context context;

    /**
     * @param context
     */
    public BaseRoute(Context context) {
        this.context = context;
        this.intent = new Intent();
    }

    /**
     * @param cls
     * @return Route
     */
    public BaseRoute to(Class<?> cls) {
        this.intent.setClass(this.context, cls);
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
     *
     * @param condition
     */
    public void start(boolean condition) {
        if (condition) {
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

    public void startOnClick(View view, final boolean condition) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (condition) {
                    start();
                }
            }
        });
    }

    /**
     * @param key
     * @return String
     */
    public String getString(String key) {
        return this.intent.getStringExtra(key);
    }

    /**
     * @param key
     * @return int
     */
    public int getInt(String key) {
        return this.intent.getIntExtra(key, 0);
    }

    /**
     * @param key
     * @return boolean
     */
    public boolean has(String key) {
        return this.intent.hasExtra(key);
    }

    /**
     * @param key
     * @return
     */
    public boolean gteBoolean(String key) {
        return this.intent.getBooleanExtra(key, false);
    }

    /**
     * @param number
     * @return
     */
    public BaseRoute call(String number) {
        this.intent.setAction(Intent.ACTION_DIAL);
        String p = "tel:" + number;
        this.intent.setData(Uri.parse(p));
        return this;
    }

    /**
     * @param url
     * @return
     */
    public BaseRoute url(String url) {
        this.intent.setAction(Intent.ACTION_VIEW);
        this.intent.addCategory(Intent.CATEGORY_BROWSABLE);
        this.intent.setData(Uri.parse(url));
        return this;
    }

    /**
     * @param title
     * @param url
     * @return
     */
    public BaseRoute shareTextUrl(@NonNull String title, @NonNull String url) {
        this.intent.setAction(Intent.ACTION_SEND);
        this.intent.setType("text/plain");
        this.intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
        withData(Intent.EXTRA_SUBJECT, title);
        withData(Intent.EXTRA_TEXT, url);
        return this;
    }
}