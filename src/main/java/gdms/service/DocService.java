package gdms.service;

import java.util.List;

import gdms.model.Doc;

public interface DocService {
	public boolean addDoc(Doc newDoc);
	public List<Doc> getDocsByUid(String uid);
	public String downloadById(int docId);
}
