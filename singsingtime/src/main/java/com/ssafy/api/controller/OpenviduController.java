package com.ssafy.api.controller;

import com.ssafy.api.service.DiaryService;
import com.ssafy.db.entity.Diary;
import io.openvidu.java.client.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
public class OpenviduController {

	@Value("${OPENVIDU_URL}")
	private String OPENVIDU_URL;

	@Value("${OPENVIDU_SECRET}")
	private String OPENVIDU_SECRET;

	private OpenVidu openvidu;

	//private

	@PostConstruct
	public void init() {
		this.openvidu = new OpenVidu(OPENVIDU_URL, OPENVIDU_SECRET);
	}

	/**
	 * @param params The Session properties
	 * @return The Session ID
	 */
	@PostMapping("/api/sessions")
	public ResponseEntity<String> initializeSession(@RequestBody(required = false) Map<String, Object> params)
			throws OpenViduJavaClientException, OpenViduHttpException {
		SessionProperties properties = SessionProperties.fromJson(params).build();
		Session session = openvidu.createSession(properties);
		return new ResponseEntity<>(session.getSessionId(), HttpStatus.OK);
	}

	/**
	 * @param sessionId The Session in which to create the Connection
	 * @param params    The Connection properties
	 * @return The Token associated to the Connection
	 */
	@PostMapping("/api/sessions/{sessionId}/connections")
	public ResponseEntity<String> createConnection(@PathVariable("sessionId") String sessionId,
			@RequestBody(required = false) Map<String, Object> params)
			throws OpenViduJavaClientException, OpenViduHttpException {
		Session session = openvidu.getActiveSession(sessionId);
		if (session == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		ConnectionProperties properties = ConnectionProperties.fromJson(params).build();
		Connection connection = session.createConnection(properties);
		return new ResponseEntity<>(connection.getToken(), HttpStatus.OK);
	}

	@Autowired
	DiaryService diaryService;
	@ResponseBody   // Long 타입을 리턴하고 싶은 경우 붙여야 함 (Long - 객체)
	@PostMapping(value="/diary/image",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public Long saveDiary(HttpServletRequest request, @RequestParam(value="image") MultipartFile image, Diary diary) throws IOException {
		System.out.println("DiaryController.saveDiary");
		System.out.println(image);
		System.out.println(diary);
		System.out.println("------------------------------------------------------");
		Long diaryId = diaryService.keepDiary(image, diary);
		return diaryId;
	}

	@ResponseBody   // Long 타입을 리턴하고 싶은 경우 붙여야 함 (Long - 객체)
	@PostMapping(value="/diary/video",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public Long saveVideo(HttpServletRequest request, @RequestParam(value="video") MultipartFile video, Diary diary) throws IOException {
		System.out.println("DiaryController.saveDiary");
//		System.out.println(video);
		System.out.println(diary);
		System.out.println("------------------------------------------------------");
		Long diaryId = diaryService.keepVideo(video, diary);
		return diaryId;
	}

}
