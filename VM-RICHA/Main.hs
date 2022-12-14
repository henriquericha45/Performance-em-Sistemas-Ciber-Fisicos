-- Henrique Levandoski Richa

{- 1. Em Haskell temos um conjunto de tipos especiais: Maybe, Nothing e Just seu trabalho será
criar no repl.it um código, comentado, que explique estes tipos, sua funcionalidade e que
contenha quatro exemplos do seu uso. Com uma restrição: você deve evitar qualquer
explicação que inclua o uso de Monads. Lembre-se entre estes exemplos, um deve ser de
sua autoria e todos os outros precisam ter suas fontes citadas. -}

{-
Nothing representa uma constante, que aponta que o valor opcional não foi informado.
Just representa sucesso, retornando algum certo valor.
Maybe representa sucesso ou falha em alguma operação.
-}

-- A função abaixo recebe um número inteiro e retorna para "talvez" um boleano, 
-- que retornará "Just True" se o número for par e "Nothing" se não for par.
-- Função de minha autoria.
par :: Int -> Maybe Bool
par x = 
  if (mod x 2 == 0) 
    then Just True 
  else Nothing

-- Esta função realiza uma divisão de maneira "segura" com o uso de Maybe, Just e Nothing.
-- Quando falo que ela faz uma divisão segura, quero dizer que ela realiza uma divisão normal,
-- porém, se for uma divisão por 0, para evitar erros, a função retorna "Nothing".
-- Na primeira linha da função ela indica que precisa de dois números do tipo Double
-- e precisa retornar um Maybe Double.
-- A segunda linha da função é uma regra de parada, e nela ocorre o uso de um _,
-- por que o valor é insignificante e verifica se o segundo valor é 0, se for retorna Nothing.
-- Na terceira linha da função ela apenas realiza a divisão.
-- Fonte: http://www.decom.ufop.br/romildo/2014-2/bcc222/practices/progfunc.pdf
-- página 178
safediv :: Double -> Double -> Maybe Double
safediv _ 0 = Nothing
safediv x y = Just (x / y)

-- Na primeira linha da função ela indica que precisa de um inteiro como entrada 
-- e retorna um Maybe Bool.
-- O resto da função verifica se o número de entrada é 2, se for retorna Just True, 
-- no caso de não for, ela verifica se o número de entrada é maior que 2 ou o resto da divisão
-- por 2 é 0, se a condição for verdadeira, retorna Nothing. Em qualquer outro caso
-- retorna Just True
-- Função de minha autoria.
ehPrimo :: Int -> Maybe Bool 
ehPrimo x = 
  if (x == 2) 
    then Just True 
  else if (x < 2 || mod x 2 == 0) 
    then Nothing 
  else Just True

-- A função abaixo verifica se um número de entrada está na lista de entrada.
-- Na primeira linha ela define as entradas, sendo um inteiro e uma lista de inteiros, e retorna
-- um Maybe Bool.
-- A segunda linha é uma condição de parada, que por ser uma função que faz o uso recursivo
-- dela mesma necessita dessa condição, e nessa linha ela verifica se a lista está vazia, que
-- significa que o número de entrada não está na lista, então retorna Nothing.
-- No resto da função no primeiro if ele verifica se o número é a "head" da lista, se for
-- verdade retorna Just True, no caso de não for, ocorre a chamada da função novamente até que
-- a função ache o número e retorne Just True ou ela fique vazia e retorne Nothing.
-- Função de minha autoria.
taNaLista :: Int -> [Int] -> Maybe Bool
taNaLista _ [] = Nothing
taNaLista x (h:t) = 
  if (x == h) then Just True 
  else taNaLista x t

{- 2. Escreva uma função chamada idade que usando pelo menos um tipo definido por você que
receba o tempo de vida em segundos de uma determinada pessoa, o nome de um planeta
e devolva a idade desta pessoa em anos caso ela tivesse vivido naquele planeta. Sabendo
que o período orbital dos planetas é dado por:
a. Mercúrio: 0.2408467 anos terrestres;
b. Vênus: 0.61519726 anos terrestres;
c. Terra: 1.0 anos terrestre equivalente a 365.25 dias, ou 31.557.600 segundos;
d. Marte: 1.8808158 anos terrestres;
e. Jupiter: 11.862615 anos terrestres;
f. Saturno: 29.447498 anos terrestres;
g. Urano: 84.016846 anos terrestres;
h. Netuno: 164.79132 anos terrestres; -}
idade :: Double -> String -> Maybe Double
idade x "mercurio" = Just (x / transformaEmSegundos (0.2408467))
idade x "venus" = Just (x / transformaEmSegundos (0.61519726))
idade x "terra" = Just (x / transformaEmSegundos (1))
idade x "marte" = Just (x / transformaEmSegundos (1.8808158))
idade x "jupiter" = Just (x / transformaEmSegundos (11.862615))
idade x "saturno" = Just (x / transformaEmSegundos (29.447498))
idade x "urano" = Just (x / transformaEmSegundos (84.016846))
idade x "netuno" = Just (x / transformaEmSegundos (164.79132))
idade x _ = Nothing

transformaEmSegundos :: Double -> Double
transformaEmSegundos x = x * 31557600

{- 3. Dada uma coleção de números, implemente as funções manter e descartar que recebem a
coleção e um predicado. Sempre que o predicado for verdadeiro quando aplicado a um item
da coleção original este item deve ser mantido ou descartado. Lembre-se dos valores
imutáveis. Você não pode usar as funções filter e reject já disponíveis no Prelude ou em
qualquer outra biblioteca. -}

-- funcao manter recebe uma lista de inteiros e uma funcao que recebe um inteiro e retorna um Maybe Bool

manter :: [Int] -> (Int -> Maybe Bool) -> [Int]
manter [] _ = []
manter (h:t) f = 
  if (f h == Just True) 
    then h : manter t f
  else manter t f

-- funcao descartar recebe uma lista de inteiros e uma funcao que recebe um inteiro e retorna um Maybe Bool

descartar :: [Int] -> (Int -> Maybe Bool) -> [Int]
descartar [] _ = []
descartar (h:t) f = 
  if (f h == Just True) then descartar t f
  else h : descartar t f

{- 4. Escreva uma função chamada maior que recebe uma coleção de números e devolve o

maior número da coleção. Você não pode usar as funções maximum e max já disponíveis no
Prelude ou em qualquer outra biblioteca. -}

maior :: [Int] -> Maybe Int
maior [] = Nothing
maior (h:t) = Just (maiorAux h t)

maiorAux :: Int -> [Int] -> Int
maiorAux x [] = x
maiorAux x (h:t) = 
  if (x > h) then maiorAux x t
  else maiorAux h t

{- 5. Escreva uma função chamada menor que recebe uma coleção de números e devolve o
menor número da coleção. Você não pode usar as funções minimum e min já disponíveis no
Prelude ou em qualquer outra biblioteca. -}

menor :: [Int] -> Maybe Int
menor [] = Nothing






{- 4. Um dos jogos infantis mais populares no planeta, chamado de Jogo Da Forca, consiste na
escolha de letras do alfabeto latino para tentar encontrar uma palavra que esteja oculta.
Você deve implementar uma versão deste jogo em Haskell considerando as seguintes
restrições: você deverá usar caracteres ASCII para representar a forca, o enforcado, e os
espaços selecionados para cada palavra; os símbolos usados nas palavras serão apenas os
caracteres do alfabeto latino minúsculos entre a e z; o banco de dados de palavras deve
conter, no mínimo 10 palavras de 6 letras ou mais; a cada tentativa a tela precisa ser limpa
e redesenhada (ANSI Escape Codes · GitHub). No repl.it não é possível importar a biblioteca
responsável pela geração de números randômicos, pode gerar as palavras e usá-las em
sequência ou, se preferir, use algum fator do sistema, como os últimos dígitos da data
corrente (Dates and Times (sourceforge.net)) -}


main = do
  putStrLn "Hello World"

  

  -- 21 anos em segundos = 662709600
  print(idade 662709600 "terra")