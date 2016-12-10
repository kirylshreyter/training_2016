package com.kirylshreyter.training.hotel.daodb.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.kirylshreyter.training.hotel.daoapi.ICommon;
import com.kirylshreyter.training.hotel.daodb.util.MapperInitializer;

@Repository
public class CommonDaoDbImpl implements ICommon {

	private static final Logger LOGGER = LoggerFactory.getLogger(CommonDaoDbImpl.class);

	@Inject
	private JdbcTemplate jdbcTemplate;

	@Inject
	private MapperInitializer mapperInitializer;

	@Override
	public <T> Object get(Object obj, Long id) {

		Map<Object, Object> map = mapperInitializer.initializeMapper();
		Object object = map.get(obj.getClass().getName());
		Class<?> modelClass = null;
		try {
			modelClass = Class.forName(object.toString());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Object objectModel = null;
		try {
			objectModel = modelClass.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String SELECT_SQL = "SELECT * FROM %s WHERE id = %s";
		String resultTable = null;

		resultTable = configureAffectedTableName(obj);
		SELECT_SQL = String.format(SELECT_SQL, resultTable, id);

		try {
			return jdbcTemplate.queryForObject(SELECT_SQL, (RowMapper<T>) objectModel);
		} catch (EmptyResultDataAccessException e) {
			return null;

		}
	}

	private String configureAffectedTableName(Object obj) {
		String resultTable;
		String[] pr = obj.getClass().getSimpleName().split("(?=\\p{Lu})");

		for (int i = 0; i < pr.length; i++) {
			pr[i] = pr[i].toLowerCase();
		}
		List<String> list = new ArrayList<>();
		list = Arrays.asList(pr);
		Iterator<String> itr = list.iterator();
		resultTable = itr.next().toString();
		while (itr.hasNext()) {
			resultTable = resultTable + "_" + itr.next().toString();
		}
		return resultTable;
	}

	@Override
	public Boolean delete(Object obj, Long id) {
		
		String fs = "Trying to delete %s with id = %s.";

		LOGGER.info(String.format(fs, obj.getClass().getSimpleName().toLowerCase(), id));

		Integer deletedRows = null;

		String SELECT_SQL = "DELETE FROM %s WHERE id = %s";

		String resultTable = configureAffectedTableName(obj);

		SELECT_SQL = String.format(SELECT_SQL, resultTable, id);

		try {
			deletedRows = jdbcTemplate.update(SELECT_SQL);

		} catch (DataIntegrityViolationException e) {
			String s = "Cannot delete %s with id = %s. Id-key of this object is used as foreign key in other table.";
			LOGGER.info(String.format(s, obj.getClass().getSimpleName().toLowerCase(), id));
			return false;
		} catch (Exception e) {
			LOGGER.info(e.getMessage());
			return false;
		}
		if (deletedRows == 0) {
			String s = "%s was NOT deleted. Client with id = %s does not exist.";
			LOGGER.info(String.format(s, obj.getClass().getSimpleName(), id));
			return false;
		} else {
			String s = "%s with id = %s was deleted.";
			LOGGER.info(String.format(s, obj.getClass().getSimpleName(), id));
			return true;
		}
	}
}
