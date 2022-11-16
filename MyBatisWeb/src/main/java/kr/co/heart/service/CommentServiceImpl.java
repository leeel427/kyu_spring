package kr.co.heart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.heart.dao.BoardDao;
import kr.co.heart.dao.CommentDao;
import kr.co.heart.domain.CommentDto;

@Service
public class CommentServiceImpl implements CommentService {

	BoardDao boardDao;
	CommentDao commentDao;

	//@Autowired
	public CommentServiceImpl(BoardDao boardDao, CommentDao commentDao) {
		//super();
		this.boardDao = boardDao;
		this.commentDao = commentDao;
	}
	

	@Override
	public List<CommentDto> getList(Integer bno) throws Exception {
		
	//	throw new Exception("test");				// 강제로 에러 만들기
		return commentDao.selectAll(bno);
	}
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int remove(Integer cno, Integer bno, String commenter) throws Exception {
		int rowCnt = boardDao.updateCommentCnt(bno, -1);
		System.out.println("updateCommentCnt - rowCnt = " + rowCnt);
				
		rowCnt = commentDao.delete(cno, commenter);
		System.out.println("rowCont = " + rowCnt);
		
		return rowCnt;
		
	}

}
