package xin.aliya.url.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import xin.aliya.url.model.Mapper;
import xin.aliya.url.service.MapperService;

import static xin.aliya.url.util.Constant.MESSAGE_CREATION_EXISTED;

@Controller
@RequestMapping("mapper")
public class MapperController extends BaseController {

    private static final String CHARACTER = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final MapperService mapperService;

    @Autowired
    public MapperController(MapperService mapperService) {
        this.mapperService = mapperService;
    }

    @RequestMapping("create")
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
        session.setAttribute("mapper", mapper);
        return "redirect:/default.jsp";
    }

    private Mapper getMapperByOriginal(String original) {
        return mapperService.queryOne("getMapperByOriginal", original);
    }

    /**
     * 6位，包含数字0-9，字母 a-z A-Z  62进制？
     * 1-1
     * 100-a
     * 100=62+38 1B
     * @return  短链的随机字符串
     */
    private String getCreation() {
        // TODO: 7/28/17
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            stringBuilder.append(CHARACTER.toCharArray()[(int) (Math.random() * 62)]);
        }
        return stringBuilder.toString();
    }

    private boolean isCreationExisted(String creation) {
        return mapperService.queryOne("queryMapperByCreation", creation) != null;
    }
}