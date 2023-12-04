package org.doit.ky.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReplyPageDTO {

	private List<ReplyVO> list;
	private int replyCnt;
}
