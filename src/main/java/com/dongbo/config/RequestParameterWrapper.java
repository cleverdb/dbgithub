package com.dongbo.config;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class RequestParameterWrapper extends HttpServletRequestWrapper  {

	private Map<String , String[]> params =  new HashMap<String, String[]>();
	
	
	public RequestParameterWrapper(HttpServletRequest request) {
		super(request);
		params.putAll(request.getParameterMap());
	}
	
	@Override
	 public String getParameter(String name) {
		String[] str = this.params.get(name);
		if(str != null && str.length > 0 ) return str[0];
        return null;
    }
	
	@Override
    public String[] getParameterValues(String name) {
        String[] results = this.params.get(name);
        if (results != null && results.length > 0)return results;
            return null;
    }
	
    public void addParameters(Map<String, Object> extraParams) {
        for (Map.Entry<String, Object> entry : extraParams.entrySet()) {
            addParameter(entry.getKey(), entry.getValue());
        }
    }

    public void addParameter(String name, Object value) {
        if (value != null) {
            if (value instanceof String[]) {
                params.put(name, (String[]) value);
            } else if (value instanceof String) {
                params.put(name, new String[]{(String) value});
            } else {
                params.put(name, new String[]{String.valueOf(value)});
            }
        }
    }
    

}
