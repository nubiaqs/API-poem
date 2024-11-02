package com.poema_api.poema_api.local

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.random.Random


class PoemaController {

    data class Poema(val texto: String)

    @RestController
    @RequestMapping("/api")
    class PoemaController {

        private val poemas = listOf(
            Poema("Rosas são vermelhas, violetas são azuis..."),
            Poema("No meio do caminho tinha uma pedra..."),
            Poema("Eu sou feito de sonhos interrompidos..."),
            Poema("A noite vem com seu manto escuro, Estrelas dançam em um céu puro. Mistérios guardados em seu véu, Silêncio profundo, encanto do céu."),
            Poema("Teu amor é como a brisa suave, Que acaricia e traz paz à alma. Em cada olhar, um universo inteiro, Te amarei sempre, meu doce anseio."),
            Poema("Caminhos trilhados, destinos a seguir, Cada passo dado, um sonho a fluir. A vida é uma estrada, cheia de surpresas, Seguindo em frente, em busca de belezas."),
            Poema("Saudade é um eco que não se apaga, Lembranças dançam, a alma se entrega. No coração guardo cada momento, E em cada lembrança, um suave tormento."),
            Poema("A floresta canta, o rio murmura, A natureza vive em sua loucura. Pássaros voam, flores a brotar, Em cada canto, a vida a se encantar."),
            Poema("A vida é um ciclo, sempre a mudar, Das folhas que caem ao sol a brilhar. Em cada transformação, um aprendizado, No fluxo do tempo, tudo é sagrado."),
            Poema("Mesmo nas sombras, a luz há de brilhar, Esperança renasce, pronta a se alçar. Nos momentos difíceis, um novo amanhecer, A vida é um presente, um eterno renascer."),
            Poema("As palavras dançam, em versos se formam, Na mente criativa, ideias se transformam. A arte é a alma que fala em silêncio, Cada poema é um mundo, um novo começo."),
            Poema("Felicidade é um instante fugaz, Como o brilho das estrelas, um doce eficaz. Nos sorrisos compartilhados, no amor sincero, Encontramos a vida em seu tom mais vero.")

        )


        @GetMapping("/poema")
        fun getPoema(): Poema {
            return poemas[Random.nextInt(poemas.size)]
        }
    }

}