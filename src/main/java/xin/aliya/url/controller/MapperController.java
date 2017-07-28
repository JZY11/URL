package xin.aliya.url.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import xin.aliya.url.model.Mapper;
import xin.aliya.url.service.MapperService;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import static xin.aliya.url.util.Constant.CHARSET;
import static xin.aliya.url.util.Constant.MESSAGE_CREATION_EXISTED;

@Controller
//@RequestMapping("mapper")
public class MapperController extends BaseController {

//    private static final String CHARSET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final MapperService mapperService;

    @Autowired
    public MapperController(MapperService mapperService) {
        this.mapperService = mapperService;
    }

    @RequestMapping(method = RequestMethod.GET)
    private void redirect(){
        String creation = request.getRequestURI().substring(1);
        Mapper mapper = mapperService.queryOne("queryMapperByCreation", creation);
//        response.sendRedirect(mapper.);
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    private String create(Mapper mapper) {
        Mapper mapperInDb = getMapperByOriginal(mapper.getOriginal());
        if (mapperInDb == null) {
            if (mapper.getCreation().isEmpty()) {
                mapper.setCreation(getCreation());
            } else {
                if (isCreationExisted(mapper.getCreation())) {
                    session.setAttribute("message", MESSAGE_CREATION_EXISTED);
                    mapper.setCreation(getCreation());
                }
            }
            mapperService.create(mapper);
        } else {
            mapper = mapperInDb;
        }
        genQrCode(mapper);
        session.setAttribute("mapper", mapper);
        return "redirect:/default.jsp";
    }

    private void genQrCode(Mapper mapper) {
        OutputStream outputStream = null;
        try {
            String path = request.getRealPath("/") + "assets/qrcode/";
            outputStream = new FileOutputStream(path + mapper.getCreation() + ".png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        QRCode.from(mapper.getOriginal())
                .withSize(500, 500)
                .withColor(0xFFFF0000, 0xFFFFFFAA)
                .to(ImageType.PNG)
                .writeTo(outputStream);
    }


    private Mapper getMapperByOriginal(String original) {
        return mapperService.queryOne("getMapperByOriginal", original);
    }

    /**
     * 8位，包含数字0-9，字母 a-z A-Z  62进制？
     * 1-1
     * 100-a
     * 100=62+38 1B
     * @return  短链的字符串(唯一)
     */
    private String getCreation() {
        long nano = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        int j = (int) Math.ceil(Math.log(nano) / Math.log(CHARSET.length()));
        for (int i = 0; i < j; i++) {
            stringBuilder.append(CHARSET.charAt((int) (nano % CHARSET.length())));
            nano /= CHARSET.length();
        }
        return stringBuilder.reverse().toString();
    }

    private boolean isCreationExisted(String creation) {
        return mapperService.queryOne("queryMapperByCreation", creation) != null;
    }

    public static void main(String[] args) {
        /*
        String s = "1C"; // 100=1*62^1+C*62^0 1C
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            num += CHARSET.indexOf(s.charAt(i)) * Math.pow(62, s.length() - i - 1);
        }
        System.out.println(num);
        */
    }
}