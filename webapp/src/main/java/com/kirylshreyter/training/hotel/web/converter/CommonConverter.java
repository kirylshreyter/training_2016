package com.kirylshreyter.training.hotel.web.converter;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.ReflectionUtils.FieldCallback;

import com.kirylshreyter.training.hotel.datamodel.Client;
import com.kirylshreyter.training.hotel.web.model.ClientModel;

public class CommonConverter implements Converter<Client, ClientModel> {
	/*Reflections reflections = new Reflections("my.project.prefix");

	 Set<Class<? extends Object>> allClasses = 
	     reflections.getSubTypesOf(Object.class);
	
	public Map<String, Object> toMap(Object object) throws Exception
	{
	    Map<String, Object> map = new LinkedHashMap<>();
	    for ( Field field : object.getClass().getDeclaredFields() )
	    {
	        field.setAccessible( true );
	        map.put( field.getName(), field.get( object ) );
	    }
	    return map;
	}
	
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	

	@Override
	public ClientModel convert(Client arg0) {

		return ClientToClientModelConverter(arg0);
	}

	private ClientModel ClientToClientModelConverter(Client client) {
		ClientModel clientModel = new ClientModel();
		final List<String> clientNames = new ArrayList<String>();
		ReflectionUtils.doWithFields(client.getClass(), new FieldCallback() {
			public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
				clientNames.add(field.getName());
			}
		});
		final List<String> clientModelNames = new ArrayList<String>();
		ReflectionUtils.doWithFields(clientModel.getClass(), new FieldCallback() {
			public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
				clientModelNames.add(field.getName());
			}
		});
		for (int i = 0; i < clientNames.size(); i++) {
			clientNames.set(i, clientNames.get(i).substring(0, 1).toUpperCase() + clientNames.get(i).substring(1));
		}
		for (int i = 0; i < clientModelNames.size(); i++) {
			clientModelNames.set(i,
					clientModelNames.get(i).substring(0, 1).toUpperCase() + clientModelNames.get(i).substring(1));
		}

		clientModelNames.retainAll(clientNames);

		for (int i = 0; i < clientModelNames.size(); i++) {
			Method getMethod = null;
			Object a = null;
			try {
				getMethod = Client.class.getMethod("get" + clientModelNames.get(i));
				try {

					a = getMethod.invoke(client);

				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (NoSuchMethodException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SecurityException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println(getMethod.toString());
			try {
				String str;
				str = "set" + clientModelNames.get(i);
				try {
					ClientModel.class.getMethod(str, a.getClass()).invoke(clientModel, a);
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalArgumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InvocationTargetException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return clientModel;

	}

}
