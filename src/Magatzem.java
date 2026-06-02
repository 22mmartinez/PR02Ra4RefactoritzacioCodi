class Magatzem {
    Article[] articles;

    public Magatzem(Article[] articles) {
        this.articles = articles;
    }

    public void actualitzarEstat() {
        for (int i = 0; i < articles.length; i++) {
            Article article = articles[i];

            // 1. Cas Llegendari: El Martell de Thor no fa absolutament res
            if (article.nom.equals("Martell de Thor (Llegendari)")) {
                continue;
            }

            // NUEVO: Cas Formatge Gidurat (Aislado y limpio)
            if (article.nom.equals("Formatge Gidurat")) {
                article.diesPerVendre--; // Cada día baja el tiempo para vender

                if (article.qualitat < 50) {
                    article.qualitat++; // Sube 1 de calidad
                }
                // Si ya ha caducado, sube otro punto extra (el doble de rápido)
                if (article.diesPerVendre < 0 && article.qualitat < 50) {
                    article.qualitat++;
                }
                continue; // 🚀 ¡EXPULSIÓN! El queso se procesa aquí y salta al siguiente artículo
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
