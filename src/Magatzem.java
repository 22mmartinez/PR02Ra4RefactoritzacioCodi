class Magatzem {
    Article[] articles;

    public Magatzem(Article[] articles) {
        this.articles = articles;
    }

    public void actualitzarEstat() {
        for (int i = 0; i < articles.length; i++) {
            Article article = articles[i];

            // 1. Cas Llegendari
            if (article.nom.equals("Martell de Thor (Llegendari)")) {
                continue;
            }

            // 2. Cas Formatge Gidurat
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

            //  NUEVO: Cas Entrades per al Concert (Limpio y ordenado)
            if (article.nom.equals("Entrades per al Concert del Trobador")) {
                article.diesPerVendre--;

                // Si el concierto ya ha pasado, la calidad cae a cero de golpe
                if (article.diesPerVendre < 0) {
                    article.qualitat = 0;
                    continue; // 🚀 ¡EXPULSIÓN!
                }

                if (article.qualitat < 50) {
                    article.qualitat++; // Subida estándar (+1) si quedan más de 10 días

                    if (article.diesPerVendre < 10 && article.qualitat < 50) {
                        article.qualitat++; // Entre 10 y 6 días (un punto extra, total +2)
                    }
                    if (article.diesPerVendre < 5 && article.qualitat < 50) {
                        article.qualitat++; // 5 días o menos (otro punto extra, total +3)
                    }
                }
                continue; // 🚀 ¡EXPULSIÓN!
            }

            if (!articles[i].nom.equals("Formatge Gidurat")
                    && !articles[i].nom.equals("Entrades per al Concert del Trobador")) {
                if (articles[i].qualitat > 0) {
                    if (!articles[i].nom.equals("Martell de Thor (Llegendari)")) {
                        articles[i].qualitat = articles[i].qualitat - 1;
                    }
                }
            } else {
                if (articles[i].qualitat < 50) {
                    articles[i].qualitat = articles[i].qualitat + 1;

                    if (articles[i].nom.equals("Entrades per al Concert del Trobador")) {
                        if (articles[i].diesPerVendre < 11) {
                            if (articles[i].qualitat < 50) {
                                articles[i].qualitat = articles[i].qualitat + 1;
                            }
                        }

                        if (articles[i].diesPerVendre < 6) {
                            if (articles[i].qualitat < 50) {
                                articles[i].qualitat = articles[i].qualitat + 1;
                            }
                        }
                    }
                }
            }

            if (!articles[i].nom.equals("Martell de Thor (Llegendari)")) {
                articles[i].diesPerVendre = articles[i].diesPerVendre - 1;
            }

            if (articles[i].diesPerVendre < 0) {
                if (!articles[i].nom.equals("Formatge Gidurat")) {
                    if (!articles[i].nom.equals("Entrades per al Concert del Trobador")) {
                        if (articles[i].qualitat > 0) {
                            if (!articles[i].nom.equals("Martell de Thor (Llegendari)")) {
                                articles[i].qualitat = articles[i].qualitat - 1;
                            }
                        }
                    } else {
                        articles[i].qualitat = articles[i].qualitat - articles[i].qualitat;
                    }
                } else {
                    if (articles[i].qualitat < 50) {
                        articles[i].qualitat = articles[i].qualitat + 1;
                    }
                }
            }
        }
    }
}
