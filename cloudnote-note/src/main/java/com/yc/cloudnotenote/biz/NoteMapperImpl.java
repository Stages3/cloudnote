//package com.yc.cloudnotenote.biz;
//
//import com.yc.cloudnote.bean.Note;
//import com.yc.cloudnote.bean.Notebook;
//import com.yc.cloudnotenote.dao.INoteMapper;
//import com.yc.cloudnote.enums.NoteStatusEnum;
//import com.yc.cloudnote.vo.Result;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.List;
//
//public class NoteMapperImpl implements INoteMapper {
//
//    @Autowired
//    private INoteMapper noteMapper;
//
//    @Override
//    public List<Note> findBynotebookid(int notebookid) {
//        return noteMapper.findBynotebookid(notebookid);
//    }
//
//    @Override
//    public List<Note> findByNoteid(int noteid) {
//        return noteMapper.findByNoteid(noteid);
//    }
//
//    @Override
//    public List<Note> findAllNote() {
//        return noteMapper.findAllNote();
//    }
//
//    @Override
//    public int insert(Note note) {
//
//        note.setNotetype(NoteStatusEnum.NEW.getCode());
//        note.setNotelastmodifytime(note.getDeliverytime());
//        int a=noteMapper.insert(note);
//        return a;
//    }
//
//    @Override
//    public int update(Note note) {
////        note.setNotestatus(NoteStatusEnum.FINISHED.getCode());
//        return noteMapper.update(note);
//    }
//
//    @Override
//    public int delete(int id) {
//
//        return 0;
//    }
//}
