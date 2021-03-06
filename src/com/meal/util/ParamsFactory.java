package com.meal.util;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/**
 * @author xiamingxing
 *
 */
public class ParamsFactory {

    private StringBuffer parametersBuffer;

    /**
     *
     */
    public ParamsFactory() {

        this.parametersBuffer = new StringBuffer();

    }

    /**
     * @param key
     * @param _value
     * @return
     */
    public ParamsFactory add(String key, Object _value) {

        if (null != key && null != _value) {

            String value = String.valueOf(_value);

            if (0 != parametersBuffer.length()) {

                parametersBuffer.append("&");

            }

            try {

                parametersBuffer.append(key).append("=")
                        .append(URLEncoder.encode(value, "utf-8"));

            } catch (Exception e) {

                e.printStackTrace();

            }

        }

        return this;

    }

    /**
     * @param map
     * @return
     */
    public String parser(HashMap<String, String> map) {

        if (null != map) {

            Iterator it = map.entrySet().iterator();

            while (it.hasNext()) {

                Entry item = (Entry) it.next();

                if (null != item) {

                    add(item.getKey().toString(), item.getValue());

                }

            }
        }

        return getParams();

    }

    /**
     * @return
     */
    public String getParams() {

        String parameters = parametersBuffer.toString();

        return parameters;

    }
}
