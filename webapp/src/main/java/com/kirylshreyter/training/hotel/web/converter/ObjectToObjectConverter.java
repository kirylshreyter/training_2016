package com.kirylshreyter.training.hotel.web.converter;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.ReflectionUtils.FieldCallback;

import com.kirylshreyter.training.hotel.web.utils.ObjectIdentifier;

@Component
public class ObjectToObjectConverter implements Converter<Object, Object> {

	@Inject
	private ObjectIdentifier objectIdentifier;

	@Override
	public Object convert(Object arg0) {

		try {
			return ObjectToModel(arg0);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	private Object ObjectToModel(Object object)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		String model = objectIdentifier.idendifyAnObject(object).toString();
		
		Object objectModel = getInstanceFromObjectString(model);

		final List<String> objectNames = new ArrayList<String>();
		ReflectionUtils.doWithFields(object.getClass(), new FieldCallback() {
			public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
				objectNames.add(field.getName());
			}
		});
		final List<String> objectModelNames = new ArrayList<String>();
		ReflectionUtils.doWithFields(objectModel.getClass(), new FieldCallback() {
			public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
				objectModelNames.add(field.getName());
			}
		});
		for (int i = 0; i < objectNames.size(); i++) {
			objectNames.set(i, objectNames.get(i).substring(0, 1).toUpperCase() + objectNames.get(i).substring(1));
		}
		for (int i = 0; i < objectModelNames.size(); i++) {
			objectModelNames.set(i,
					objectModelNames.get(i).substring(0, 1).toUpperCase() + objectModelNames.get(i).substring(1));
		}

		objectModelNames.retainAll(objectNames);

		for (int i = 0; i < objectModelNames.size(); i++) {
			Method getMethod = null;
			Object a = null;
			try {
				getMethod = object.getClass().getMethod("get" + objectModelNames.get(i));
				try {

					a = getMethod.invoke(object);

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
			try {
				String str;
				str = "set" + objectModelNames.get(i);
				try {
					objectModel.getClass().getMethod(str, a.getClass()).invoke(objectModel, a);
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
		return objectModel;

	}

	public Object getInstanceFromObjectString(String model)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> modelClass = Class.forName(model.toString());
		Object objectModel = modelClass.newInstance();
		return objectModel;
	}

}
