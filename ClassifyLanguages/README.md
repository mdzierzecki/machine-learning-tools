# Classify languages: single-layer neuron network [Java]

It is a simple language classifier (English/Czech/German), which uses perceptron to do it. 

We have few subdirectories for every languages and texts in this languages (10 texts for each). At startup, the perceptron network will use these texts as training data.

We take the document in any language (in Latin alphabet) from the ".txt" file,
we throw away all characters except letters of the English alphabet (ascii), normalize text etc and
we convert into a 26-element vector of letter proportions (i.e. what is the proportion of 'a', 'b', etc.)

It turns out that such a character distribution vector is enough to distinguish the language of a natural text document, 

We create 1 layer of K perceptrons (where K is the number of languages, suppose K = 3 languages) and we teach each perceptron to recognize "its own" language.

Teaching the perceptrons is with a discrete (0-1) activation function of each perceptron.

Becouse of high similarity of results, we need to use Euclidean measure to figur out which language it is (sometimes two perceoptrons are going to be activated).

Moreover I provided simple GUI to check any new text.

Everything has been done without any Machine Learning external libraries.
