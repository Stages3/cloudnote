package com.yc.cloudnotenote;

import com.yc.cloudnote.bean.Note;
import com.yc.cloudnotenote.dao.INoteMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class CloudnoteNoteApplicationTests {
	@Resource
	private INoteMapper noteMapper;

	@Test
	void contextLoads() {
		Note note=new Note();
		note.setNoteid(5);
		note.setNotestatus(0);
		noteMapper.update(note);
	}

}
