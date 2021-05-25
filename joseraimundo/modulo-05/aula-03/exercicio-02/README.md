### Descrição

Criaremos uma classe que nos permitirá criar dinamicamente instâncias de diferentes objetos. Uma fábrica genérica. Para isso, será necessário investigar algumas questões.

Usaremos as classes Properties, Class e mais algumas.


Criar uma interface chamada Sorter<T>, com o método abstrato public void sort(T arr[],Comparator<T> c).

Criar uma classe chamada QuickSortSorterImple que implemente a interface (em T) acima e sobrescreva o método sort (deixá-lo vazio por enquanto).

Buscar na internet alguma implementação do algoritmo de ordenação QuickSort (buscar pelas palavras: QuickSort.java) e utilizá-lo para programar o método sort da questão anterior, fazendo as modificações que sejam necessárias.

Idem aos exercícios 2 e 3, porém com o algoritmo de ordenação HeapSort, criando a classe HeapSortSorterImple

Idem aos exercícios 2 e 3, porém com o algoritmo de ordenação BubbleSort, criando a classe BubbleSortSorterImple.

Crie um arquivo de texto chamado MyFactory.properties na pasta do seu projeto. O conteúdo do arquivo deve ser: sorter=package.QuickSortSorterImple (sem aspas ou qualquer coisa diferente do que está destacado em amarelo).

Crie a classe MyFactory com o método public static Object getInstance (String objName).
Usando a classe Properties (investigue) leia o conteúdo da propriedade "sorter" do arquivo criado em (6), que neste caso será a string: "package.QuickSortSorterImple".

Usando a classe Class (investigar), crie dinamicamente um objeto do tipo obtido em (8) e o retorne.

Crie um programa, instancie um Sorter usando Factory, classifique um array de inteiros e outro de strings.

Modifique a implementação do objeto Sort em MyFactory.properties, para uma das outras implementações disponíveis (bubble ou heap).

Provar que tudo funciona corretamente.

Crie uma classe chamada Time, com dois métodos: start e stop, que respectivamente salvam a hora atual expressa em milissegundos em variáveis ​​de instância (investigue como fazer isso).

Adicione à classe Timer o método elapsedTime que retorna o tempo decorrido entre a hora de início (início) e a hora de término (parada).

Crie uma matriz de 5.000 valores inteiros, ordenados do maior para o menor. (Pesquise como ler e escrever o arquivo)


### Saída do programa


	|------- sorterQuick-------|
	Print dos dez primeiros números antes e deopis
	76 57 42 30 16 63 66 5 63 15 
	99 97 96 94 92 90 88 86 84 82 
	Total time:5
	|------- sorterBubble-------|
	Print dos dez primeiros números antes e deopis
	1 37 44 19 71 29 48 16 61 54 
	99 97 95 93 91 89 87 85 83 80 
	Total time:191
	|------- sorterHeap-------|
	Print dos dez primeiros números antes e deopis
	86 98 61 0 46 69 28 9 5 4 
	99 98 96 94 92 90 88 86 84 82 
	Total time:4

	Process finished with exit code 0

