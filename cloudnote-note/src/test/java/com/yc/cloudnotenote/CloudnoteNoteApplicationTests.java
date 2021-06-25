package com.yc.cloudnotenote;

import com.yc.cloudnote.bean.Activitydetail;
import com.yc.cloudnote.bean.Note;
import com.yc.cloudnote.bean.Notebook;
import com.yc.cloudnote.bean.Share;
import com.yc.cloudnotenote.dao.IActivityDetailMapper;
import com.yc.cloudnotenote.dao.INoteBookMapper;
import com.yc.cloudnotenote.dao.INoteMapper;
import com.yc.cloudnotenote.dao.IShareMapper;
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

	@Resource
	private INoteBookMapper noteBookMapper;
	@Resource
	private IShareMapper shareMapper;
	@Test
	void contextLoads() {
//		Note note=new Note();
//		note.setNoteid(5);
//		note.setNotestatus(0);
//		noteMapper.update(note);
//		Activitydetail activitydetail=new Activitydetail();
//		activitydetail.setNoteactivityid(1);
//		activitydetail.setNoteactivityup();
//		detailMapper.updateup(activitydetail);
//		detailMapper.updatedown(activitydetail);
		Share share=new Share();
		share.setSharetitle("测试");
		share.setNoteid(1);
		shareMapper.share(share);
	}

	@Test
	void update(){
//		Notebook notebook=new Notebook();
//		notebook.setNotebookid(15);
//		notebook.setNotebookstatus(0);
//		noteBookMapper.updatestatus(notebook);
		Note note=new Note();
		note.setNoteid(5);
		note.setNotetitle("ceshi ");
		note.setNotebody("ceshi1");
		note.setNotelastmodifytime(note.getDeliverytime());
		noteMapper.updatenote(note);
	}

}
