class Magatzem {
    Article[] articles;

    public Magatzem(Article[] articles) {
        this.articles = articles;
    }

    public void actualitzarEstat() {
        for (int i = 0; i < articles.length; i++) {
            Article article = articles[i];

            // 1. Martell de Thor (Llegendari)
            if (article.nom.equals("Martell de Thor (Llegendari)")) {
                continue;
            }

            // 2. Formatge Gidurat
            if (article.nom.equals("Formatge Gidurat")) {
                article.diesPerVendre--;
                if (article.qualitat < 50) {
                    article.qualitat++;
                }
                if (article.diesPerVendre < 0 && article.qualitat < 50) {
                    article.qualitat++;
                }
                continue;
            }

            // 3. Entrades per al Concert
            if (article.nom.equals("Entrades per al Concert del Trobador")) {
                article.diesPerVendre--;
                if (article.diesPerVendre < 0) {
                    article.qualitat = 0;
                    continue;
                }
                if (article.qualitat < 50) {
                    article.qualitat++;
                    if (article.diesPerVendre < 10 && article.qualitat < 50) {
                        article.qualitat++;
                    }
                    if (article.diesPerVendre < 5 && article.qualitat < 50) {
                        article.qualitat++;
                    }
                }
                continue;
            }

            // 4. Articles Normals (Només arriba aquí el que no s'ha interceptat dalt)
            article.diesPerVendre--;
            if (article.qualitat > 0) {
                article.qualitat--;
            }
            if (article.diesPerVendre < 0 && article.qualitat > 0) {
                article.qualitat--; // Baixa el doble de ràpid si ha caducat
            }
        }
    }
}
