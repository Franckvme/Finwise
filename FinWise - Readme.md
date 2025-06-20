🎯 Vue d'ensemble
FinWise est une application web moderne de gestion financière personnelle qui utilise l'intelligence artificielle pour automatiser la catégorisation des transactions, fournir des insights personnalisés et aider les utilisateurs à optimiser leurs finances.
✨ Fonctionnalités principales

🤖 Catégorisation automatique par IA - Classification intelligente des transactions
📊 Dashboard interactif - Visualisations dynamiques de vos finances
📱 Interface responsive - Compatible mobile, tablette et desktop
🔒 Sécurité renforcée - Chiffrement des données et authentification JWT
📈 Gestion des budgets - Suivi et alertes automatiques
📄 Import intelligent - Support CSV, OFX, QIF avec détection automatique
🔍 Détection d'anomalies - Identification des dépenses inhabituelles
📊 Rapports détaillés - Analyses mensuelles et tendances

🏗️ Architecture
Stack technique

Frontend: Angular 18+ avec TypeScript
Backend: Spring Boot 3.x avec Java 21
Base de données: PostgreSQL 15+
IA/ML: API OpenAI / Modèles locaux
Sécurité: Spring Security + JWT
Cache: Redis (optionnel)

Structure du projet
finwise/
├── frontend/           # Application Angular
│   ├── src/
│   │   ├── app/
│   │   ├── assets/
│   │   └── environments/
│   ├── package.json
│   └── angular.json
├── backend/            # API Spring Boot
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   └── resources/
│   │   └── test/
│   ├── pom.xml
│   └── Dockerfile
├── docs/               # Documentation
├── docker-compose.yml
└── README.md
🚀 Installation et Configuration
Prérequis

Java 21+
Node.js 18+
PostgreSQL 15+
Maven 3.8+
Angular CLI 18+

Installation rapide avec Docker
bash# Cloner le repository
git clone https://github.com/votre-username/finwise.git
cd finwise

# Lancer avec Docker Compose
docker-compose up -d

# L'application sera disponible sur http://localhost:4200
Installation manuelle
1. Base de données
sql-- Créer la base de données
CREATE DATABASE finwise;
CREATE USER finwise_user WITH PASSWORD 'your_password';
GRANT ALL PRIVILEGES ON DATABASE finwise TO finwise_user;
2. Backend (Spring Boot)
bashcd backend
# Configurer application.properties
cp src/main/resources/application.properties.example src/main/resources/application.properties

# Installer les dépendances et lancer
mvn clean install
mvn spring-boot:run
3. Frontend (Angular)
bashcd frontend
# Installer les dépendances
npm install

# Lancer en mode développement
ng serve

# Build pour production
ng build --prod
⚙️ Configuration
Variables d'environnement
Backend (.env ou application.properties)
properties# Base de données
DB_HOST=localhost
DB_PORT=5432
DB_NAME=finwise
DB_USERNAME=finwise_user
DB_PASSWORD=your_password

# JWT
JWT_SECRET=your-super-secret-jwt-key
JWT_EXPIRATION=86400000

# IA/OpenAI
OPENAI_API_KEY=your-openai-api-key
OPENAI_MODEL=gpt-4-turbo

# Email (optionnel)
SMTP_HOST=smtp.gmail.com
SMTP_PORT=587
SMTP_USERNAME=your-email@gmail.com
SMTP_PASSWORD=your-app-password
Frontend (environment.ts)
typescriptexport const environment = {
  production: false,
  apiUrl: 'http://localhost:8080/api',
  features: {
    aiCategorization: true,
    budgetAlerts: true,
    fileImport: true
  }
};
📋 Utilisation
1. Première connexion

Créer un compte utilisateur
Ajouter vos comptes bancaires
Importer vos premières transactions

2. Import de transactions
bash# Formats supportés
- CSV (date, libellé, montant, solde)
- OFX (format bancaire standard)
- QIF (format Quicken)

# Exemple CSV
Date,Libellé,Montant,Solde
2024-01-15,"Achat Carrefour",-45.67,1234.56
2024-01-16,"Virement salaire",2500.00,3734.56
3. API Endpoints principaux
POST /api/auth/login          # Connexion
POST /api/auth/register       # Inscription
GET  /api/accounts           # Liste des comptes
POST /api/transactions       # Créer transaction
POST /api/transactions/import # Importer fichier
GET  /api/dashboard          # Données dashboard
POST /api/ai/categorize      # Catégorisation IA
🧪 Tests
Tests Backend
bashcd backend
mvn test                    # Tests unitaires
mvn verify                  # Tests d'intégration
Tests Frontend
bashcd frontend
npm test                    # Tests unitaires
npm run e2e                # Tests end-to-end
📊 Fonctionnalités IA
Catégorisation automatique

Analyse du libellé des transactions
Apprentissage des habitudes utilisateur
Score de confiance pour chaque catégorie
Amélioration continue du modèle

Détection d'anomalies

Identification des dépenses inhabituelles
Alertes en temps réel
Analyse des patterns de dépenses

Insights personnalisés

Recommandations d'économies
Prédictions de budget
Analyse comparative des dépenses

🔒 Sécurité

Chiffrement AES-256 des données sensibles
Authentification JWT avec expiration
HTTPS obligatoire en production
Validation stricte des entrées
Protection CSRF/XSS
Audit logging des actions sensibles

🚀 Déploiement
Docker Production
bash# Build des images
docker-compose -f docker-compose.prod.yml build

# Déploiement
docker-compose -f docker-compose.prod.yml up -d
Variables de production
bash# Sécurité
JWT_SECRET=super-long-random-production-secret
DB_PASSWORD=strong-production-password

# Performance
JAVA_OPTS=-Xmx2g -Xms1g
POSTGRES_SHARED_BUFFERS=256MB
📈 Monitoring
Health Checks

/actuator/health - Santé de l'application
/actuator/metrics - Métriques de performance
/actuator/info - Informations système

Logs
bash# Logs application
tail -f logs/finwise.log

# Logs base de données
tail -f /var/log/postgresql/postgresql.log
🤝 Contribution
Guidelines

Fork le projet
Créer une branche feature (git checkout -b feature/nouvelle-fonctionnalite)
Commit les changements (git commit -am 'Ajout nouvelle fonctionnalité')
Push vers la branche (git push origin feature/nouvelle-fonctionnalite)
Créer une Pull Request

Standards de code

Java: Google Java Style Guide
TypeScript: Angular Style Guide
Tests: Couverture minimale 80%
Documentation: JSDoc pour les fonctions publiques

📝 Changelog
Version 1.0.0 (En développement)

✅ Authentification utilisateur
✅ Gestion des comptes bancaires
✅ Import de transactions
✅ Catégorisation IA
✅ Dashboard interactif
🔄 Gestion des budgets
🔄 Rapports avancés
🔄 Application mobile

🐛 Problèmes connus

Import OFX: Certaines banques utilisent des formats non-standard
IA: Première catégorisation peut nécessiter du feedback utilisateur
Performance: Optimisation nécessaire pour >10k transactions

📞 Support

Documentation: Wiki du projet
Issues: GitHub Issues
Discussions: GitHub Discussions

📄 Licence
Ce projet est sous licence MIT. Voir le fichier LICENSE pour plus de détails.
