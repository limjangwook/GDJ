package com.gdu.app09.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BoardDTO {
	private int boardNo;
	private String title, content, writer, createDate, modifyDate;
<<<<<<< HEAD
	public String getBoardNo() {
		// TODO Auto-generated method stub
		return null;
	}
=======
>>>>>>> 0549f84d3d88a9670db9fceffd1b520e1509c8ac
}
