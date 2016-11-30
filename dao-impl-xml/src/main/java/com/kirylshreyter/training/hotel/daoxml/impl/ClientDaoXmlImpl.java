package com.kirylshreyter.training.hotel.daoxml.impl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.kirylshreyter.training.hotel.daoapi.IClientDao;
import com.kirylshreyter.training.hotel.datamodel.Client;

@Repository
public class ClientDaoXmlImpl implements IClientDao {

	@Inject
	private Common common;

	// private File file;

	/*
	 * @Override public Book get(Long id) { List<Book> allBooks =
	 * readCollection();
	 * 
	 * for (Book book : allBooks) { if (book.getId().equals(id)) { return book;
	 * } } return null; }
	 */

	/*
	 * @Override public void delete(Long id) { List<Book> allBooks =
	 * readCollection();
	 * 
	 * List<Book> newList = new ArrayList<>(); // TODO: don't iterate whole
	 * collection for (Book book : allBooks) { if (!book.getId().equals(id)) {
	 * newList.add(book); } } writeCollection(newList); }
	 */

	/*
	 * @Override public List<Book> getAll() { return readCollection(); }
	 */
	@Override
	public Long insert(Client entity) {
		List<Client> allClients = readCollection(entity);
		Long id = getNextId(allClients);

		allClients.add(entity);

		entity.setId(new Long(id));

		writeCollection(allClients);
		return id;
	}

	/*
	 * @Override public void update(Book entity) { // TODO throw new
	 * UnsupportedOperationException(); }
	 */

	private List<Client> readCollection(Client entity) {
		try {
			common.intialize(entity);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (List<Client>) Common.xstream.fromXML(Common.file);
	}

	private void writeCollection(List<Client> newList) {
		try {
			Common.xstream.toXML(newList, new FileOutputStream(Common.file));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);// TODO custom exception
		}
	}

	private long getNextId(List<Client> allClients) {
		return allClients.isEmpty() ? 1l : allClients.get(allClients.size() - 1).getId() + 1;
	}

	@Override
	public Client get(Long id) {
		List<Client> allClients = readCollection(new Client());
		for (Client client : allClients) {
			if (client.getId().equals(id)) {
				return client;
			}
		}
		return null;
	}

	@Override
	public Boolean update(Client entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> getAll() {
		Client client = new Client();
		return readCollection(client);
	}

}
