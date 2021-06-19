package com.yc.cloudnotenote;

import com.yc.cloudnote.bean.Activitydetail;
import com.yc.cloudnote.bean.Note;
import com.yc.cloudnotenote.dao.IActivityDetailMapper;
import com.yc.cloudnotenote.dao.INoteMapper;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class CloudnoteNoteApplicationTests {
	@Resource
	private INoteMapper noteMapper;

	@Resource
	private IActivityDetailMapper detailMapper;

	@Test
	void contextLoads() {
//		Note note=new Note();
//		note.setNoteid(5);
//		note.setNotestatus(0);
//		noteMapper.update(note);
		Activitydetail activitydetail=new Activitydetail();
		activitydetail.setNoteactivityid(1);
//		activitydetail.setNoteactivityup();
		detailMapper.updateup(activitydetail);
		detailMapper.updatedown(activitydetail);

	}

}
