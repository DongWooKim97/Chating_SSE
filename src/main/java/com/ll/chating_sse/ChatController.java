package com.ll.chating_sse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/chat")
public class ChatController {

    private final List<ChatMessage> chatMessages = new ArrayList<>();

    public record WriteMessageResponse(long id) {
    }

    @PostMapping("/writeMessage")
    @ResponseBody
    public ResultData writeMessage() {
        ChatMessage msg = new ChatMessage("홍길동", "Hello World!");

        chatMessages.add(msg);

        return new ResultData(
                "S-1",
                "메세지가 작성되었습니다.",
                new WriteMessageResponse(msg.getId())
        );
    }

    @GetMapping("/messages")
    @ResponseBody
    public ResultData<List<ChatMessage>> messages() {
        return new ResultData(
                "S-1",
                "성공",
                chatMessages
        );
    }

}
