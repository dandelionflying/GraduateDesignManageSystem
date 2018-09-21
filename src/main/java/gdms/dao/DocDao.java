package gdms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import gdms.model.Doc;

@Repository
public interface DocDao {
	public boolean insertDoc(Doc newDoc);
	public List<Doc> getDocsBySid(@Param("uid")String uid);
}
