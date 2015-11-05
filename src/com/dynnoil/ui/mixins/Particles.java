package com.dynnoil.ui.mixins;

import org.apache.tapestry5.MarkupWriter;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.MixinAfter;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;

import javax.inject.Inject;

/**
 * Класс-миксин, представляющий собой
 * эффект за заднем фоне компонента
 * <p/>
 * Created by krukov on 28.10.2015.
 */
@Import(library = "particles/particles.js",
        stylesheet = "particles/demo/css/style.css")
public class Particles {

    /**
     * Внедрение услуги для добавления
     * JavaScript в компонент
     */
    @Inject
    private JavaScriptSupport javaScriptSupport;

    /**
     * Событие, обрабатываемое в начале
     * рендеринга миксина
     *
     * @param writer
     */
    void beforeRenderTemplate(MarkupWriter writer) {
        writer.element("div", "id", "particles-js");
            writer.end();
                javaScriptSupport.addScript("particlesJS('particles-js',\n" +
                        "  \n" +
                        "  {\n" +
                        "    \"particles\": {\n" +
                        "      \"number\": {\n" +
                        "        \"value\": 80,\n" +
                        "        \"density\": {\n" +
                        "          \"enable\": true,\n" +
                        "          \"value_area\": 800\n" +
                        "        }\n" +
                        "      },\n" +
                        "      \"color\": {\n" +
                        "        \"value\": \"#ffffff\"\n" +
                        "      },\n" +
                        "      \"shape\": {\n" +
                        "        \"type\": \"circle\",\n" +
                        "        \"stroke\": {\n" +
                        "          \"width\": 0,\n" +
                        "          \"color\": \"#000000\"\n" +
                        "        },\n" +
                        "        \"polygon\": {\n" +
                        "          \"nb_sides\": 5\n" +
                        "        },\n" +
                        "        \"image\": {\n" +
                        "          \"src\": \"img/github.svg\",\n" +
                        "          \"width\": 100,\n" +
                        "          \"height\": 100\n" +
                        "        }\n" +
                        "      },\n" +
                        "      \"opacity\": {\n" +
                        "        \"value\": 0.5,\n" +
                        "        \"random\": false,\n" +
                        "        \"anim\": {\n" +
                        "          \"enable\": false,\n" +
                        "          \"speed\": 1,\n" +
                        "          \"opacity_min\": 0.1,\n" +
                        "          \"sync\": false\n" +
                        "        }\n" +
                        "      },\n" +
                        "      \"size\": {\n" +
                        "        \"value\": 5,\n" +
                        "        \"random\": true,\n" +
                        "        \"anim\": {\n" +
                        "          \"enable\": false,\n" +
                        "          \"speed\": 40,\n" +
                        "          \"size_min\": 0.1,\n" +
                        "          \"sync\": false\n" +
                        "        }\n" +
                        "      },\n" +
                        "      \"line_linked\": {\n" +
                        "        \"enable\": true,\n" +
                        "        \"distance\": 150,\n" +
                        "        \"color\": \"#ffffff\",\n" +
                        "        \"opacity\": 0.4,\n" +
                        "        \"width\": 1\n" +
                        "      },\n" +
                        "      \"move\": {\n" +
                        "        \"enable\": true,\n" +
                        "        \"speed\": 6,\n" +
                        "        \"direction\": \"none\",\n" +
                        "        \"random\": false,\n" +
                        "        \"straight\": false,\n" +
                        "        \"out_mode\": \"out\",\n" +
                        "        \"attract\": {\n" +
                        "          \"enable\": false,\n" +
                        "          \"rotateX\": 600,\n" +
                        "          \"rotateY\": 1200\n" +
                        "        }\n" +
                        "      }\n" +
                        "    },\n" +
                        "    \"interactivity\": {\n" +
                        "      \"detect_on\": \"canvas\",\n" +
                        "      \"events\": {\n" +
                        "        \"onhover\": {\n" +
                        "          \"enable\": true,\n" +
                        "          \"mode\": \"repulse\"\n" +
                        "        },\n" +
                        "        \"onclick\": {\n" +
                        "          \"enable\": true,\n" +
                        "          \"mode\": \"push\"\n" +
                        "        },\n" +
                        "        \"resize\": true\n" +
                        "      },\n" +
                        "      \"modes\": {\n" +
                        "        \"grab\": {\n" +
                        "          \"distance\": 400,\n" +
                        "          \"line_linked\": {\n" +
                        "            \"opacity\": 1\n" +
                        "          }\n" +
                        "        },\n" +
                        "        \"bubble\": {\n" +
                        "          \"distance\": 400,\n" +
                        "          \"size\": 40,\n" +
                        "          \"duration\": 2,\n" +
                        "          \"opacity\": 8,\n" +
                        "          \"speed\": 3\n" +
                        "        },\n" +
                        "        \"repulse\": {\n" +
                        "          \"distance\": 200\n" +
                        "        },\n" +
                        "        \"push\": {\n" +
                        "          \"particles_nb\": 4\n" +
                        "        },\n" +
                        "        \"remove\": {\n" +
                        "          \"particles_nb\": 2\n" +
                        "        }\n" +
                        "      }\n" +
                        "    },\n" +
                        "    \"retina_detect\": true,\n" +
                        "    \"config_demo\": {\n" +
                        "      \"hide_card\": false,\n" +
                        "      \"background_color\": \"#b61924\",\n" +
                        "      \"background_image\": \"\",\n" +
                        "      \"background_position\": \"50% 50%\",\n" +
                        "      \"background_repeat\": \"no-repeat\",\n" +
                        "      \"background_size\": \"cover\"\n" +
                        "    }\n" +
                        "  }\n" +
                        "\n" +
                        ");");


    }

    /**
     * Событие, обрабатываемое после рендеринга
     * миксина
     *
     * @param writer
     */
    void afterRenderTemplate(MarkupWriter writer) {

    }

}
